package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Ticket extends BaseClass {

  List<ShowSeat> showSeats;
  Float amount;
  List<Payment> payments;
  TicketStatus ticketStatus;
  User user;
}