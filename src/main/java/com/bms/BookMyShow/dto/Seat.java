package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseClass {
  private String name;
  private int row;
  private int col;
  private SeatType seatType;
}
