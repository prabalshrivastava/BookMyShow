package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Auditorium extends BaseClass {
  private String name;
  private List<Seat> seats;
  private List<MovieFormat> movieFormats;
}
