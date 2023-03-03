package com.BookMyShow.Entities;
import com.BookMyShow.Enums.MovieLanguage;
import com.BookMyShow.Enums.MovieType;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
@Entity
@Table ( name = "movie")
public class Movie {

    @Id
    @GeneratedValue ( strategy =  GenerationType.IDENTITY )
    private int id ;

    @Column ( unique = true , nullable = false )
    private String name ;

    private double rating ;

    private int duration ;

    @Enumerated ( value = EnumType.STRING)
    private MovieLanguage movieLanguage ;

    @Enumerated ( value = EnumType.STRING)
    private MovieType movieType ;

    // Many : One = Show : Movie ( Movie Parents , Show Child )
    @OneToMany(mappedBy = "movie" , cascade = CascadeType.ALL)
    List< Show > showLists = new ArrayList<>() ;
}
