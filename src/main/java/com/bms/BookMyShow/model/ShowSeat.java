package com.bms.BookMyShow.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
/**
 * Avengers 5pm is a show
 * A1-Recliner is a seat
 * A ShowSeat is the Avengers 5pm Recliner A1
 */
public class ShowSeat extends BaseModel {

  /**
   * 1 ShowSeat has only 1 show -> 1 Avengers@5pm@Audi1@A1 can have only Avengers Running
   * 1 Show can have multiple ShowSeat -> 1 Avengers@5pm@Audi1 can have multiple seats Avengers@5pm@Audi1@A1,Avengers@5pm@Audi1@A2,Avengers@5pm@Audi1@A3
   */
  @ManyToOne
  private Show show;
  /**
   * 1 ShowSeat can have 1 Seat ->  Avengers@5pm@Audi1@A1 can only be associated with A1
   * 1 Seat can have multiple ShowSeat -> A1 can have multiple seats Avengers@5pm@Audi1@A1,Avengers@7pm@Audi1@A1,Avengers@5pm@Audi2@A1
   */
  @ManyToOne
  private Seat seat;
  /**
   * 1 ShowSeat can have 1 ShowSeatState -> Avengers@5pm@Audi1@A1 is BOOKED
   * 1 ShowSeatState can be associated with multiple ShowSeat. -> BOOKED ShowSeatState are Avengers@5pm@Audi1@A1,Avengers@5pm@Audi1@A2,Avengers@5pm@Audi1@A3
   */
//  @ManyToOne
  @Enumerated(EnumType.ORDINAL)
  private ShowSeatState showSeatState;
}
