package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;

@Data
@Entity
/**
 * Avengers 5pm is a show
 * Recliner is a seat
 * A ShowSeat is the Avengers 5pm Recliner seat can have A1,A2....
 */
public class ShowSeat extends BaseClass {
  private Show show;
  private List<Seat> seat;
  private ShowSeatStatus showSeatStatus;
}
