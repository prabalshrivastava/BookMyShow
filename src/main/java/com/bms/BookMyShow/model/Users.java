package com.bms.BookMyShow.model;

import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Users extends BaseModel {
  String name;
  //we can add further fields.
}