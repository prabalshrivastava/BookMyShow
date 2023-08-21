package com.bms.BookMyShow.dto;

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
   * 1 Ticket has multiple ShowSeat -> Ticket 999 has Avengers@5pm@Audi1@A1,Avengers@5pm@Audi1@A2,Avengers@5pm@Audi1@A3
   * 1 ShowSeat is only associated with 1 ticket -> Avengers@5pm@Audi1@A1 is associated with the ticket 999
   */
  @OneToMany
  List<ShowSeat> showSeats;
  Float amount;
  /**
   * 1 Ticket has multiple Payment -> Ticket 999 has payment through Paytm@100,Phonepe@200,CC@300 ie total of 600rs through 3 portals.
   * 1 Payment is only associated with 1 ticket -> Paytm@100 is associated with the ticket 999
   */
  @OneToMany
  List<Payment> payments;
  /**
   * 1 Ticket has 1 TicketStatus -> Ticket 999 is Booked
   * 1 TicketStatus is associated with multiple ticket -> Booked are ticket 999,213
   */
//  @ManyToOne
  @Enumerated(EnumType.STRING)
  TicketStatus ticketStatus;
  /**
   * 1 Ticket has 1 User -> Ticket 999 belongs to Prabal
   * 1 User can have multiple tickets -> Prabal has ticket 999,213
   */
  @ManyToOne
  User user;
}