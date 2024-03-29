package com.bms.BookMyShow.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import lombok.Data;

@Data
@Entity
public class Profile extends BaseModel {
  String name;
  /**
   * 1 Casting/Person can have 1 gender eg male
   * 1 Gender can belong to muliple Person/Casting eg Male are  Robert Downey Jr,Shah ruk khan
   */
  @Enumerated(EnumType.ORDINAL)
//  @OneToMany
  Gender gender;
  Byte age;
  byte[] photo;
}
