package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@Entity
public class Profile extends BaseClass {
  String name;
  Gender gender;
  Byte age;
  byte[] photo;
}
