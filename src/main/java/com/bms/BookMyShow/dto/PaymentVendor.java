package com.bms.BookMyShow.dto;

import java.net.URI;
import javax.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class PaymentVendor extends BaseModel {
  String name;
  URI payEndPoint;
  URI retrievePayInfo;
}
