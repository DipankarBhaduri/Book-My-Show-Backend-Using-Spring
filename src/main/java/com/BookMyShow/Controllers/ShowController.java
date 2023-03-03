package com.BookMyShow.Controllers;

import com.BookMyShow.DTOs.ShowDto;
import com.BookMyShow.Services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/show")
public class ShowController {

    @Autowired
    private ShowService showService ;


    @PostMapping("/add")
    public ResponseEntity < String > addShow (@RequestBody ShowDto showDto){
        try {
              String str = showService.addShow ( showDto) ;
              return new ResponseEntity<>( str , HttpStatus.CREATED ) ;
        } catch ( Exception e ){
            return new ResponseEntity<>( e.getMessage() , HttpStatus.BAD_REQUEST) ;
        }
    }
}
