package com.BookMyShow.Convertors;
import com.BookMyShow.DTOs.TheaterDto;
import com.BookMyShow.Entities.Theater;

public class TheaterConverter {

    public static Theater convertDtoToTheater (TheaterDto theaterDto ){
        Theater theater = Theater.builder()
                .name(theaterDto.getName())
                .location(theaterDto.getLocation())
                .build() ;

        return theater ;
    }
}
