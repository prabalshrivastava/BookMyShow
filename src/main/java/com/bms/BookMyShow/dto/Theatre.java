package com.bms.BookMyShow.dto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Theatre extends BaseModel {
  private String name;
  private String address;
  /**
   * 1 Theatre SAM can have multiple Auditorium Audi1,Audi2
   * 1 Auditorium Audi1 can belong to 1 theater SAM
    */
  @OneToMany
  private List<Auditorium> auditoriums;
  /**
   * 1 Theatre can belong to a single city eg SAM is in Jabalpur
   * 1 City can have many theaters eg Jabalpur has SAM,Samdariya,Jyoti Talkies.
   */
  @ManyToOne
  private City city;
}
