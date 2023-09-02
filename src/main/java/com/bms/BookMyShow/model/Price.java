package com.bms.BookMyShow.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Price extends BaseModel {

  Double base;
  Double fees;
  Double taxes;
  Double total;
  /**
   * 1 Price can have 1 discount associated
   * 1 Discount can be associated with multiple Prices
   */
  @ManyToOne
  Discount discount;
}
