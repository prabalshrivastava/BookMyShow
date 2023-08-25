package com.bms.BookMyShow.dto;

import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Discount extends BaseModel {
  @ElementCollection
  List<String> promotionalVouchers;
  @ElementCollection
  List<String> paymentVendorDiscount;
}
