package com.bms.BookMyShow.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
public class Seat extends BaseModel {
  private String name;
  private int row;
  private int col;
  /**
   * 1 Seat A1 has a single SeatType ie RECLINER
   * 1 SeatType RECLINER can belong to multiple seats A1,A2....
   */
//  @ManyToOne
  @Enumerated(EnumType.STRING)
  private SeatType seatType;
}
