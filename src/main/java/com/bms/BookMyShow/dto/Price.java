package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Price extends BaseModel {

  Double base;
  Double fees;
  Double taxes;
  Double total;
  Discount discount;
}