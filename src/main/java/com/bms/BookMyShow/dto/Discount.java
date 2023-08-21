package com.bms.BookMyShow.dto;

import java.util.List;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class Discount extends BaseModel {
  List<String> promotionalVouchers;
  List<String> paymentVendorDiscount;
}
