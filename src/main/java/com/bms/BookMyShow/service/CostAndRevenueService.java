package com.bms.BookMyShow.service;

import com.bms.BookMyShow.model.ShowSeat;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CostAndRevenueService {

  public double calculateTotalAmount(List<ShowSeat> showSeatList) {
    //currently only 100Rs static ticket is being returned we can do it on a dynamic basis also.
    return showSeatList.size()*100;
  }
}
