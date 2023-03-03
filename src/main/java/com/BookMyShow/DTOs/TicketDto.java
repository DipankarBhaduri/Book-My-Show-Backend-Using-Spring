package com.BookMyShow.DTOs;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class TicketDto {
    private int showId ;
    private int userId ;
    private List< String > requestedSeats = new ArrayList<>() ;

}
