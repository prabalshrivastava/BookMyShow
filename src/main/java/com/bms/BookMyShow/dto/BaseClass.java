package com.bms.BookMyShow.dto;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseClass {
  @Id
  private int id;
}
