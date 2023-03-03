package com.BookMyShow.Entities;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Builder
@Table ( name = "theater" )
public class Theater {


    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id ;
    private String name ;
    private String location ;


    // Many : One = Show : Theater ( Show Child , Theater Parents )
    @OneToMany ( mappedBy = "theater" , cascade = CascadeType.ALL)
    List<Show> showList = new ArrayList<>() ;


   // One : Many = Theater : TheaterSeat ( Theater Parent , TheaterSeat Child )
    @OneToMany ( mappedBy = "theater" , cascade = CascadeType.ALL)
    List < TheaterSeat > theaterSeats = new ArrayList<>() ;

}
