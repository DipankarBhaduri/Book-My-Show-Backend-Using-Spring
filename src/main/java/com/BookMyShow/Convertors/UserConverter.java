package com.BookMyShow.Convertors;

import com.BookMyShow.DTOs.UserEntryDto;
import com.BookMyShow.Entities.User;

public class UserConverter {
     public static User converDtoToUserEntity (UserEntryDto userEntryDto ){
         // This is one easy way to convert Dto to entity :
         // first we have to set static name = "build in the all argsConductor : and then --- here
         // User user = User.build( 0 , userEntryDto.getName() , userEntryDto.getEmail() , userEntryDto.getAge() ,userEntryDto.getMobNo() ,userEntryDto.getAddress());

         // This is one easy way to convert Dto to entity :
         //  1 > @AllArgsConstructor  2 > Builder :) in the entity class :
         // 3 > process is here :

         User user =  User.builder().age(userEntryDto.getAge()).name(userEntryDto.getName()).
                 email(userEntryDto.getEmail()).address(userEntryDto.getAddress()).
                 mobNo(userEntryDto.getMobNo()).build() ;

         return user ;
     }
}
