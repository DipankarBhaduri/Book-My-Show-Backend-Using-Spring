package com.BookMyShow.Services;
import com.BookMyShow.Convertors.ShowConverter;
import com.BookMyShow.DTOs.ShowDto;
import com.BookMyShow.Entities.*;
import com.BookMyShow.Enums.TheaterSeatType;
import com.BookMyShow.Repositories.MovieRepository;
import com.BookMyShow.Repositories.ShowRepository;
import com.BookMyShow.Repositories.ShowSeatRepository;
import com.BookMyShow.Repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository ;

    @Autowired
    private MovieRepository movieRepository ;

    @Autowired
    private ShowSeatRepository showSeatRepository ;

    @Autowired
    private TheaterRepository theaterRepository ;


    public String addShow ( ShowDto showDto){
//        <------------Convert ShowDto to Show entity------------>
        Show show = ShowConverter.convertShowDtotoShow(showDto) ;

//        <------------ Finding all entities by Id ----------->
        Movie movie = movieRepository.findById(showDto.getMovieId()).get() ;
        Theater theater = theaterRepository.findById(showDto.getTheaterId()).get() ;

//        <----------- Set attributes for show ----------->
        show.setMovie(movie);
        show.setTheater(theater);

//        <---------------- Creating showSeat ---------------->
        List< ShowSeat > showSeatList = createShowSeat ( showDto , show );
        show.setShowSeats(showSeatList);

//        <--------------------- Setting all attributes -------------->
        List< Show> showList = theater.getShowList();
        showList.add(show);

        List < Show > movieList = movie.getShowLists() ;
        movieList.add(show);

        List< Show> showList1 = theater.getShowList();
        showList1.add(show);

        showRepository.save(show);
        theaterRepository.save(theater);
        movieRepository.save(movie);

        return "The show has been added successfully" ;
    }


    // <------------------- Creating the ShowSeat ---------------------->
    public List < ShowSeat > createShowSeat ( ShowDto showDto , Show show ){
        //<---------------- Creating object of the TheaterSeat ------------->
        Theater theater = theaterRepository.findById(showDto.getTheaterId()).get();

        // <---------------- Setting all attributes -------------------->
        List < TheaterSeat > theaterSeatList = theater.getTheaterSeats() ;
        List < ShowSeat > showSeatList = new ArrayList<>() ;

        // Setting all attributes for
        for ( TheaterSeat theaterSeat : theaterSeatList ){
            ShowSeat showSeat = new ShowSeat() ;
            showSeat.setSeatNo(theaterSeat.getSeatNo());
            showSeat.setTheaterSeatType(theaterSeat.getTheaterSeatType());
            showSeat.setShow(show);
            if ( theaterSeat.getTheaterSeatType().equals(TheaterSeatType.CLASSIC)){
                showSeat.setPrice(showDto.getClassisSeatPrice());
            } else {
                showSeat.setPrice(showDto.getPremiumSeatPrice());
            }
            showSeatList.add(showSeat) ;
        }

        return showSeatList ;
    }
}















