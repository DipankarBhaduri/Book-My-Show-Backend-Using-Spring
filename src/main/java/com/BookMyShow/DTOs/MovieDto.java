package com.BookMyShow.DTOs;

import com.BookMyShow.Enums.MovieLanguage;
import com.BookMyShow.Enums.MovieType;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class MovieDto {
    private String name ;
    private double rating ;
    private int duration ;
    private MovieLanguage movieLanguage ;
    private MovieType movieType ;
}
