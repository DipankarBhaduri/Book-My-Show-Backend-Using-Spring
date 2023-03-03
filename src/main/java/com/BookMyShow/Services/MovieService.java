package com.BookMyShow.Services;

import com.BookMyShow.Controllers.MovieController;
import com.BookMyShow.Convertors.MovieConverter;
import com.BookMyShow.DTOs.MovieDto;
import com.BookMyShow.Entities.Movie;
import com.BookMyShow.Repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository ;

    public String addMovie ( MovieDto movieDto ) {
        Movie movie = MovieConverter.convertDtoToMovie(movieDto) ;
        movieRepository.save(movie) ;
        return "Movie added successfully" ;
    }
}
