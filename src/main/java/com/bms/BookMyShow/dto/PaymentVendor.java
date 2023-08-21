package com.bms.BookMyShow.dto;

import jakarta.persistence.Entity;
import java.net.URI;
import lombok.Data;

@Data
@Entity
public class PaymentVendor extends BaseClass {

  String name;
  URI payEndPoint;
  URI retrievePayInfo;
}
