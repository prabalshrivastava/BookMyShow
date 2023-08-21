package com.bms.BookMyShow.dto;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Ticket extends BaseModel {

  /**
   * 1 Ticket has 1 User -> Ticket 999 belongs to Prabal 1 User can have multiple tickets -> Prabal
   * has ticket 999,213
   */
  @ManyToOne
  User bookedBy;

  @ManyToOne
  private Show show;

  /**
   * 1 Ticket has multiple ShowSeat -> Ticket 999 has
   * Avengers@5pm@Audi1@A1,Avengers@5pm@Audi1@A2,Avengers@5pm@Audi1@A3
   * <p>
   * 1 ShowSeat is only associated with 1 ticket -> Avengers@5pm@Audi1@A1 is associated with the
   * ticket 999
   */
  //this is different from what is taught.
  @OneToMany
  List<ShowSeat> showSeats;

  private double totalAmount;
  /**
   * 1 Ticket has 1 TicketStatus -> Ticket 999 is Booked
   * <p>
   * 1 TicketStatus is associated with multiple ticket -> Booked are ticket 999,213
   */
//  @ManyToOne
  @Enumerated(EnumType.ORDINAL)
  TicketStatus ticketStatus;
  LocalDateTime timeOfBooking;
  /**
   * 1 Ticket has multiple Payment -> Ticket 999 has payment through Paytm@100,Phonepe@200,CC@300 ie
   * total of 600rs through 3 portals.
   * <p>
   * 1 Payment is only associated with 1 ticket -> Paytm@100 is associated with the ticket 999
   */
  @OneToMany(mappedBy = "ticket")
  List<Payment> payments;

}