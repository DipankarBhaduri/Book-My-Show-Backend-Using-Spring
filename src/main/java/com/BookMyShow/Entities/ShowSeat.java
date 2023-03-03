package com.BookMyShow.Entities;
import com.BookMyShow.Enums.TheaterSeatType;
import lombok.*;
import javax.persistence.*;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table( name = "showSeat")
public class ShowSeat {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id ;

    private boolean isBooked ;

    private int price ;

    private String seatNo ;

    @Enumerated ( EnumType.STRING)
    private TheaterSeatType theaterSeatType ;

    private LocalTime bookedAt ;


    // One : Many = Show : ShowSeat ( Show Parents , ShowSeat Child )
    @ManyToOne
    @JoinColumn
    private Show show ;
}
