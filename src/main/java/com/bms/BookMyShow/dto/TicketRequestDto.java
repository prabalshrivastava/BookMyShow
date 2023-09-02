package com.bms.BookMyShow.dto;

import java.util.List;
import lombok.Data;

@Data
public class TicketRequestDto {
  //for generating a ticket the information needed would be
  //1. User that is booking the ticket
  //2. Show that he wants to book
  //3. Seats that he wants to book for that show.
  public Long userId;
  public Long showId;
  public List<Long> showSeatIds;
}
