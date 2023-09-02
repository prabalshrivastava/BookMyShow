package com.bms.BookMyShow.controllers;

import com.bms.BookMyShow.dto.TicketRequestDto;
import com.bms.BookMyShow.dto.TicketResponseDto;
import com.bms.BookMyShow.service.TicketService;
import org.springframework.stereotype.Controller;

@Controller
public class TicketController {
  private TicketService ticketService;

  public TicketController(TicketService ticketService) {
    this.ticketService = ticketService;
  }

  public TicketResponseDto generateTicket(TicketRequestDto ticketRequestDto){
    ticketService.generateTicket(ticketRequestDto.getShowSeatIds(),
        ticketRequestDto.getShowId(),ticketRequestDto.getUserId());
  }
}
