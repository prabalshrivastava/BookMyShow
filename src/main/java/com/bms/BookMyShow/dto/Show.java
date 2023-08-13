package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Show extends BaseClass {
  private LocalDateTime showStartTime;
  private LocalDateTime showEndTime;
  /**
   * m:1
   * 1 show can belong to 1 Auditorium -> Avengers 5pm can belong to Audi1
   * 1 Auditorium can have multiple shows -> Audi1 has shows as Avengers 5pm,Nemo 7pm,Dhoom 9pm
   */
  private Auditorium auditorium;
  private Movie movie;
  private ShowStatus showStatus;
  private Language language;
}
