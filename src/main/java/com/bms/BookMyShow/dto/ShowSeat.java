package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
/**
 * Avengers 5pm is a show
 * A1-Recliner is a seat
 * A ShowSeat is the Avengers 5pm Recliner A1
 */
public class ShowSeat extends BaseModel {
  private Show show;
  private Seat seat;
  private ShowSeatState showSeatState;
}
