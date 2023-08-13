package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import java.util.List;
import lombok.Data;

@Data
@Entity
@MappedSuperclass
public class Cast extends BaseClass {
  private Profile profile;
  private CastType castType;
  private List<Movie> movies;
}
