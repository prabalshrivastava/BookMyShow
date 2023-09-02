package com.bms.BookMyShow.service;

import static com.bms.BookMyShow.model.TicketStatus.Booked;

import com.bms.BookMyShow.exceptions.SeatDoesNotExistsForCurrentShowException;
import com.bms.BookMyShow.exceptions.ShowDoesNotExistsException;
import com.bms.BookMyShow.exceptions.UserDoesNotExistsException;
import com.bms.BookMyShow.model.Payment;
import com.bms.BookMyShow.model.PaymentMethod;
import com.bms.BookMyShow.model.PaymentVendor;
import com.bms.BookMyShow.model.Show;
import com.bms.BookMyShow.model.ShowSeat;
import com.bms.BookMyShow.model.ShowSeatState;
import com.bms.BookMyShow.model.Ticket;
import com.bms.BookMyShow.model.Users;
import com.bms.BookMyShow.repository.ShowRepository;
import com.bms.BookMyShow.repository.ShowSeatRepository;
import com.bms.BookMyShow.repository.TicketRepository;
import com.bms.BookMyShow.repository.UserRepository;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

@Service
public class TicketService {

  TicketRepository ticketRepository;
  ShowRepository showRepository;
  ShowSeatRepository showSeatRepository;
  UserRepository userRepository;
  CostAndRevenueService costAndRevenueService;

  public TicketService(TicketRepository ticketRepository, ShowRepository showRepository,
      ShowSeatRepository showSeatRepository, UserRepository userRepository) {
    this.ticketRepository = ticketRepository;
    this.showRepository = showRepository;
    this.showSeatRepository = showSeatRepository;
    this.userRepository = userRepository;
  }

  private static void throwSeatDoesNotExistsForCurrentShowException(ShowSeat showSeat)
      throws SeatDoesNotExistsForCurrentShowException {
    throw new SeatDoesNotExistsForCurrentShowException();
  }

  @SneakyThrows
  @Transactional
  public Ticket generateTicket(List<Long> showSeatIds, Long showId, Long userId) {
    //We need to persist the information in 3 different tables.
    //1. User table containing information about the user who is creating the ticket.
    //2. ShowSeats Object that represents the seats associated with the booked show.
    //3. Ticket Object containing the ticket information.

    //Search if the show exists in the DB.
    Optional<Show> showOptional = showRepository.findById(showId);
    Show show = null;
    if (showOptional.isPresent()) {
      show = showOptional.get();
    } else {
      throw new ShowDoesNotExistsException();
    }

    //Check if ShowSeat Objects are present in the DB.
    List<ShowSeat> showSeatList = showSeatRepository.findAllById(showSeatIds);
    showSeatList.stream().filter(showSeat -> showSeat.getShowSeatState() != ShowSeatState.AVAILABLE)
        .findAny().ifPresent(TicketService::throwSeatDoesNotExistsForCurrentShowException);

    //Check if the User exists in the DB if now we throw Exception.
    Users user = null;
    Optional<Users> usersOptional = userRepository.findById(userId);
    if (usersOptional.isPresent()) {
      user = usersOptional.get();
    } else {
      throw new UserDoesNotExistsException();
    }

    //Double check locking mechanism in place.
    for (ShowSeat showSeat : showSeatList) {
      showSeat.setShowSeatState(ShowSeatState.BOOKED);
    }

    List<ShowSeat> showSeatsWithLock = showSeatRepository.findAllByIdIn(showSeatIds);
    showSeatsWithLock.stream()
        .filter(showSeat -> showSeat.getShowSeatState() != ShowSeatState.AVAILABLE)
        .findAny().ifPresent(TicketService::throwSeatDoesNotExistsForCurrentShowException);

    showSeatRepository.saveAll(showSeatList);

    Ticket ticket = new Ticket();
    ticket.setBookedBy(user);
    ticket.setShowSeats(showSeatList);
    ticket.setTotalAmount(costAndRevenueService.calculateTotalAmount(showSeatList));
    ticket.setTicketStatus(Booked);
    ticket.setTimeOfBooking(LocalDateTime.now());
    ticket.setPayments(createPaymentsList());


    //call payment endpoint from here

    //save the ticket.
    ticketRepository.save(ticket);
  }

  @SneakyThrows
  private List<Payment> createPaymentsList() {
    ArrayList<Payment> payments = new ArrayList<>();
    Payment payment = new Payment();
    payment.setPaymentMethod(PaymentMethod.PAYPAL);
    payment.setTimeOfPayment(LocalDateTime.now());
    payment.setPaymentVendor(getPayUVendor());
    payments.add(payment);
    return payments;
  }

  private static PaymentVendor getPayUVendor() throws URISyntaxException {
    PaymentVendor paymentVendor = new PaymentVendor();
    paymentVendor.setName("PAYU");
    paymentVendor.setPayEndPoint(new URI("https://payu.com/pay"));
    paymentVendor.setRetrievePayInfo(new URI("https://payu.com/retrieve"));
    return paymentVendor;
  }
}
