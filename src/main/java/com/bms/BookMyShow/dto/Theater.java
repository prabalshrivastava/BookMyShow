package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Theater extends BaseClass {
  private String name;
  private String address;
  private List<Auditorium> auditoriums;
  private City city;
}
