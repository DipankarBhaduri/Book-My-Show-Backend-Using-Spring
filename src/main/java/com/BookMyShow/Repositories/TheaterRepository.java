package com.BookMyShow.Repositories;

import com.BookMyShow.Entities.Theater;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository <Theater, Integer > {

}
