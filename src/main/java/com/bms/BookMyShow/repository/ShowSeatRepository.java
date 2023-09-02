package com.bms.BookMyShow.repository;

import com.bms.BookMyShow.model.ShowSeat;
import java.util.List;
import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat,Long> {

  @Lock(LockModeType.PESSIMISTIC_READ)
  List<ShowSeat> findAllByIdIn(Iterable<Long> showSeatIds);
}
