package com.BookMyShow.Entities;
import com.BookMyShow.Enums.TheaterSeatType;
import lombok.*;
import javax.persistence.*;


@AllArgsConstructor
@Entity
@Builder
@Data
@Table ( name = "theaterSeat")
@NoArgsConstructor
public class TheaterSeat {


    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id ;

    @Column ( nullable = false)
    private String seatNo ;

    @Enumerated ( value = EnumType.STRING)
    private TheaterSeatType theaterSeatType ;

    // One : Many = Theater : TheaterSeat ( Theater Parent , TheaterSeat Child )

    @ManyToOne
    @JoinColumn           //  //  // (referencedColumnName = "name")
    private Theater theater ;
}
