package com.BookMyShow.Convertors;
import com.BookMyShow.DTOs.MovieDto;
import com.BookMyShow.Entities.Movie;

public class MovieConverter {
    public static Movie convertDtoToMovie (MovieDto movieDto) {
        Movie movie = Movie.builder()
                .name(movieDto.getName())
                .rating(movieDto.getRating())
                .duration(movieDto.getDuration())
                .movieLanguage(movieDto.getMovieLanguage())
                .movieType(movieDto.getMovieType())
                .build();

        return movie ;
    }
}
