package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Cast extends BaseModel {
  private Profile profile;
  private CastType castType;
  private List<Movie> movies;
}
