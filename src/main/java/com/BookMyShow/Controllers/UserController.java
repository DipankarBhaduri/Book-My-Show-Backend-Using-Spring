package com.BookMyShow.Controllers;
import com.BookMyShow.DTOs.UserEmailUpdateDto;
import com.BookMyShow.DTOs.UserEntryDto;
import com.BookMyShow.Entities.User;
import com.BookMyShow.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping ("/user")
public class UserController {

    @Autowired
    UserService userService ;

    @PostMapping ("/add")
    public ResponseEntity<String> updateUserEmail (@RequestBody UserEntryDto userEntryDto){
        try {
           String user = userService.addUser(userEntryDto) ;
            return new ResponseEntity<>( user , HttpStatus.CREATED ) ;
        } catch ( Exception e ){
            return new ResponseEntity<>( e.getMessage() , HttpStatus.BAD_REQUEST ) ;
        }
    }



    @PutMapping("/updateMail")
    public String updateUserEmail (@RequestBody UserEmailUpdateDto userEmailUpdateDto){
         return userService.updateEmail(userEmailUpdateDto) ;
    }


    @PutMapping ("/updateUser")
    public String updateUser ( @RequestBody UserEntryDto userEntryDto){
        return userService.updateUser(userEntryDto) ;
    }
}

