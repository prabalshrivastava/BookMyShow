package com.bms.BookMyShow.dto;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public class BaseModel {
  @Id
  private int id;
}
