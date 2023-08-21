package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;
import lombok.Data;

@Data
@Entity
public class Payment extends BaseModel {
  Price price;
  PaymentStatus paymentStatus;
  PaymentVendor paymentVendor;
  Integer transactionId;
  LocalDateTime currentTime;
}
