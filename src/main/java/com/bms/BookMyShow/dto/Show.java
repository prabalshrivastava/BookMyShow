package com.bms.BookMyShow.dto;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Show extends BaseModel {
  private LocalDateTime showStartTime;
  private LocalDateTime showEndTime;
  /**
   * m:1
   * 1 show can belong to 1 Auditorium -> Avengers 5pm can belong to Audi1
   * 1 Auditorium can have multiple shows -> Audi1 has shows as Avengers 5pm,Nemo 7pm,Dhoom 9pm
   */
  @ManyToOne
  private Auditorium auditorium;
  /**
   * 1 Show will have only a single movie running at a time ie Show Avengers5pm@Audi1 will only run Avengers
   * 1 Movie can be running in multiple Shows at a time eg Avengers is running at Avengers5pm@Audi1,Avengers7pm@Audi1,Avengers5pm@Audi2
   */
  @ManyToOne
  private Movie movie;
  /**
   * 1 Show can have 1 status at a time. ie Avengers5pm@Audi1 is Running
   * 1 ShowStatus can be applicable for multiple shows ie Running Shows are Avengers5pm@Audi1,Avengers7pm@Audi1,Avengers5pm@Audi2
   */
//  @ManyToOne
  @Enumerated(EnumType.ORDINAL)
  private ShowStatus showStatus;
  /**
   * 1 Show can have a single language for the current Show Avengers5pm@Audi1 is in Hindi Language
   * 1 Language can have multiple shows eg shows available in Hindi language are Avengers5pm@Audi1,Avengers7pm@Audi1
   */
//  @ManyToOne
  @Enumerated(EnumType.ORDINAL)
  private Language language;

  @ElementCollection
  @Enumerated(EnumType.ORDINAL)
  private List<MovieFormat> movieFormats;
}
