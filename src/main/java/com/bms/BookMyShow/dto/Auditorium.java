package com.bms.BookMyShow.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Auditorium extends BaseModel {
  private String name;
  /**
   * 1 Auditorium has many seats eg Audi1 has A1,A2,A3
   * 1 Seat belongs to a single Auditorium eg A1 belongs to Audi1
   */
  @OneToMany
  private List<Seat> seats;
  /**
   * 1 Auditorium had multiple MovieFormats _3D,imax,dolbyAtmos,dolbyVision
   * 1 MovieFormat can belong to multiple Auditorium eg 3D can belong to Audi1,Audi2
   */
//  @ManyToMany
  @ElementCollection
  @Enumerated(EnumType.STRING)
  private List<MovieFormat> movieFormats;
}
