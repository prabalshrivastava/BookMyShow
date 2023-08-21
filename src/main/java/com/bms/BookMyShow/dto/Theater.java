package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Theater extends BaseModel {
  private String name;
  private String address;
  /**
   * 1 Theater SAM can have multiple Auditorium Audi1,Audi2
   * 1 Auditorium Audi1 can belong to 1 theater SAM
    */
  @OneToMany
  private List<Auditorium> auditoriums;
  /**
   * 1 Theater can belong to a single city eg SAM is in Jabalpur
   * 1 City can have many theaters eg Jabalpur has SAM,Samdariya,Jyoti Talkies.
   */
  @ManyToOne
  private City city;
}
