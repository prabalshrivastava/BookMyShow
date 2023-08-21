package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Discount extends BaseClass {
  List<String> promotionalVouchers;
  List<String> paymentVendorDiscount;
}
