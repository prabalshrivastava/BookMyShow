package com.bms.BookMyShow.dto;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class City extends BaseModel {
  private String name;

  @OneToMany
  private List<Theatre> theatres;
}
