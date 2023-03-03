package com.BookMyShow.Repositories;
import com.BookMyShow.Entities.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository < ShowSeat, Integer > {

}
