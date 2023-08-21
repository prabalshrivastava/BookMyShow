package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

@Data
@Entity
public class User extends BaseClass {
  String name;
  //we can add further fields.
}