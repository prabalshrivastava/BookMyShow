package com.bms.BookMyShow.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Profile extends BaseModel {
  String name;
  /**
   * 1 Cast/Person can have 1 gender eg male
   * 1 Gender can belong to muliple Person/Cast eg Male are  Robert Downey Jr,Shah ruk khan
   */
  @Enumerated(EnumType.STRING)
//  @OneToMany
  Gender gender;
  Byte age;
  byte[] photo;
}
