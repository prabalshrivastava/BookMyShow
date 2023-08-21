package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
@Entity
public class Payment extends BaseClass {
  Price price;
  PaymentStatus paymentStatus;
  PaymentVendor paymentVendor;
  Integer transactionId;
  LocalDateTime currentTime;
}
