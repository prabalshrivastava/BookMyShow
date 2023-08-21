package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Profile extends BaseModel {
  String name;
  Gender gender;
  Byte age;
  byte[] photo;
}
