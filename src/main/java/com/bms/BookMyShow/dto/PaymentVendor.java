package com.bms.BookMyShow.dto;

import javax.persistence.Entity;
import java.net.URI;
import lombok.Data;

@Data
@Entity
public class PaymentVendor extends BaseModel {
  String name;
  URI payEndPoint;
  URI retrievePayInfo;
}
