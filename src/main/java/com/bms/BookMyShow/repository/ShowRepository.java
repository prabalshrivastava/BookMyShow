package com.bms.BookMyShow.repository;

import com.bms.BookMyShow.model.Show;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowRepository extends JpaRepository<Show,Long> {

}
