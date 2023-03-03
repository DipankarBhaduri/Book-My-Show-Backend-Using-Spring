package com.BookMyShow.Services;
import com.BookMyShow.Convertors.TheaterConverter;
import com.BookMyShow.DTOs.TheaterDto;
import com.BookMyShow.Entities.Theater;
import com.BookMyShow.Entities.TheaterSeat;
import com.BookMyShow.Enums.TheaterSeatType;
import com.BookMyShow.Repositories.TheaterRepository;
import com.BookMyShow.Repositories.TheaterSeatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository ;

    @Autowired
    TheaterRepository theaterRepository ;

    public String addTheater (TheaterDto theaterDto ){

        // Normal validation Check :-->>
        if ( theaterDto.getLocation() == null || theaterDto.getName() == null ){
            return "Location and TheaterName should be valid" ;
        }

        // <------------- Convert DTO to Entity  ----------->>
        Theater theater = TheaterConverter.convertDtoToTheater(theaterDto) ;

        // <------------ Creating the theater seats -------------->
        List<TheaterSeat> theaterSeatList =createTheaterSeats(theaterDto , theater );

        // <----------- Setting attributes and save to repository ------------>
        theater.setTheaterSeats(theaterSeatList);
        theaterRepository.save(theater);
        return "Theater added successfully" ;
    }

    private List < TheaterSeat >  createTheaterSeats (TheaterDto theaterDto , Theater theater ){
        int classicSeats = theaterDto.getNumberOfClassisSeats() ;
        int premiumSeats = theaterDto.getNumberOfPeriumSeats() ;
        List< TheaterSeat> theaterSeats = new ArrayList<>() ;

        //        <------------- Creating theaterSeat for classic ------------>
        for ( int count = 1 ; count <= classicSeats ; count ++ ){
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .theaterSeatType(TheaterSeatType.CLASSIC)
                    .seatNo(count+"C")
                    .theater(theater)
                    .build();
            theaterSeats.add(theaterSeat) ;
        }

        //        <------------- Creating theaterSeat for premium ------------>
        for ( int count = 1 ; count <= premiumSeats ; count ++ ){
            TheaterSeat theaterSeat = TheaterSeat.builder()
                    .theaterSeatType(TheaterSeatType.PREMIUM)
                    .seatNo(count+"P")
                    .theater(theater)
                    .build();
            theaterSeats.add(theaterSeat) ;
        }

        return theaterSeats ;
    }
}
