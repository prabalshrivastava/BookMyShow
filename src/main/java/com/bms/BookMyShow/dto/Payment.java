package com.bms.BookMyShow.dto;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Payment extends BaseModel {
  /**
   * 1 Payment is only associated with 1 Price -> Paytm@100 is associated with the 100rs
   * 1 Price has 1 Payment -> 100rs to be deducted via Paytm
   */
  @OneToOne
  Price price;
  /**
   * 1 Payment is only associated with 1 PaymentStatus -> Paytm@100 is Processing
   * 1 PaymentStatus can have multiple Payment -> Processing are Paytm@100,Paytm@200,CC@100
   */
//  @ManyToOne
  @Enumerated(EnumType.STRING)
  PaymentStatus paymentStatus;
  /**
   * 1 Payment is only associated with 1 PaymentVendor -> Paytm@100 is Processing via Paytm
   * 1 PaymentStatus can have multiple Payment -> Paytm are Processing Paytm@100,Paytm@200
   */
  @ManyToOne
  PaymentVendor paymentVendor;
  Integer transactionId;
  LocalDateTime currentTime;
}
