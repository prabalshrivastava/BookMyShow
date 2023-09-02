package com.bms.BookMyShow.dto;

import com.bms.BookMyShow.model.Ticket;
import lombok.Data;

@Data
public class TicketResponseDto {
  //What all information is needed in the ticket
  //1. Show Details ie Movie and which City->Theater->Auditorium is the booking for, and it's timing this all information can be extracted from the show object
  //2. Seats Details containing all the seats that are booked by the user.
  public Ticket ticket;
}
