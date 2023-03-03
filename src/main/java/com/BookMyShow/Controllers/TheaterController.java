package com.BookMyShow.Controllers;
import com.BookMyShow.DTOs.TheaterDto;
import com.BookMyShow.Services.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService ;


    @PostMapping ("/add")
    public ResponseEntity < String > addTheater(@RequestBody TheaterDto theaterDto){
        try {
            String str = theaterService.addTheater(theaterDto);
            return new ResponseEntity<>( str , HttpStatus.CREATED) ;
        } catch ( Exception e ){
            return new ResponseEntity<>( e.getMessage() , HttpStatus.BAD_REQUEST) ;
        }
    }

}
