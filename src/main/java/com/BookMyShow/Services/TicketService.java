package com.BookMyShow.Services;
import com.BookMyShow.DTOs.TicketDto;
import com.BookMyShow.Entities.Show;
import com.BookMyShow.Entities.ShowSeat;
import com.BookMyShow.Entities.Ticket;
import com.BookMyShow.Entities.User;
import com.BookMyShow.Repositories.ShowRepository;
import com.BookMyShow.Repositories.ShowSeatRepository;
import com.BookMyShow.Repositories.TicketRepository;
import com.BookMyShow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    private UserRepository userRepository ;
    @Autowired
    private ShowRepository showRepository ;
    @Autowired
    private TicketRepository ticketRepository ;

    @Autowired
    private ShowSeatRepository showSeatRepository ;

    // Add ticket to the DB
    public String bookTicket ( TicketDto ticketDto ){

        Ticket ticket = new Ticket() ;
        //   <----------------- Validation ------------------->
        try {
            User user = userRepository.findById(ticketDto.getUserId()).get() ;
            Show show = showRepository.findById(ticketDto.getShowId()).get() ;
            ticket.setMovieName(show.getMovie().getName()) ;
            ticket.setShowDate(show.getShowDate()) ;
            ticket.setShowTiming(show.getShowTime());

            int amount = calculateTotalAmount(ticketDto.getRequestedSeats() ,show , ticketDto);
            if ( amount == 0 ){
                return "This seat is already booked" ;
            }
            ticket.setPrice(amount);
            ticket.setTheaterName(show.getTheater().getName());
            String bookSeats = convertRequestedSeatListToString(ticketDto.getRequestedSeats()) ;
            ticket.setBookedSeats(bookSeats);
            ticket.setUser(user);
            ticket.setShow(show);

            ticket = ticketRepository.save(ticket) ;

            List < Ticket > userTicketList = user.getTickets();
            userTicketList.add(ticket);
            userRepository.save(user);

            List < Ticket > ticketList = show.getTicketList() ;
            ticketList.add(ticket);
            showRepository.save(show);

        } catch ( Exception e ){
            return e.getMessage() ;
        }
        return "Ticket Booked Successfully" ;
    }

    public static int calculateTotalAmount (List < String > list , Show show , TicketDto ticketDto){
        List < ShowSeat > showSeatList = show.getShowSeats() ;
        int totalAmount = 0 ;

        for ( String str : list ){
            for ( ShowSeat showSeat : showSeatList ){
                if ( showSeat.getSeatNo().equals(str)){
                    if (showSeat.isBooked()==false){
                        showSeat.setBooked(true);
                        totalAmount += showSeat.getPrice() ;
                       // showSeat.setBookedAt(ticketDto.getLocalTime());
                    } else {
                        return 0 ;
                    }
                }
            }
        }

        show.setShowSeats(showSeatList);
        return totalAmount ;
    }

    public static String convertRequestedSeatListToString ( List < String > list ){
        String ans = "" ;
        for ( String str : list ){
            ans += str+", ";
        }
        return ans ;
    }
}


















