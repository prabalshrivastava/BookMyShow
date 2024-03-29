package com.bms.BookMyShow.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Generated;

@Data
@MappedSuperclass
public class BaseModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
}
