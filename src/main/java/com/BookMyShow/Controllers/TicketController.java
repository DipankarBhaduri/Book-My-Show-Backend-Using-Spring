package com.BookMyShow.Controllers;

import com.BookMyShow.DTOs.TicketDto;
import com.BookMyShow.Entities.Ticket;
import com.BookMyShow.Services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService ;

    @PostMapping("/add")
    public ResponseEntity < String > bookTicket (@RequestBody TicketDto ticketDto ){

        try {
            String str = ticketService.bookTicket(ticketDto) ;
            return new ResponseEntity<>(str , HttpStatus.CREATED) ;
        } catch ( Exception e ){
            return new ResponseEntity<>(e.getMessage() , HttpStatus.BAD_REQUEST) ;
        }

    }

}
