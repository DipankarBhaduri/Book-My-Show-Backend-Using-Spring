package com.BookMyShow.DTOs;
import com.BookMyShow.Enums.ShowType;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowDto {

    private LocalDate showDate ;
    private LocalTime showTime ;
    private ShowType showType ;
    private int movieId ;
    private int theaterId ;
    private int classisSeatPrice ;
    private int premiumSeatPrice ;

}
