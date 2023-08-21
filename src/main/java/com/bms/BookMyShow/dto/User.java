package com.bms.BookMyShow.dto;

import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User extends BaseModel {
  String name;
  //we can add further fields.
}