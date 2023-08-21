package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class City extends BaseModel {
  private String name;
}
