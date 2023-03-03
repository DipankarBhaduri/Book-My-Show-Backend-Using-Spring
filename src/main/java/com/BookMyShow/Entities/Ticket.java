package com.BookMyShow.Entities;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table( name = "ticket")
public class Ticket {


        @Id
        @GeneratedValue( strategy = GenerationType.IDENTITY)
        private int id ;
        private int price ;
        private String movieName ;
        private LocalTime showTiming ;
        private LocalDate showDate ;
        private String bookedSeats ;
        private String theaterName ;
        private String ticketId = UUID.randomUUID().toString() ;



        // One : Many = User : Ticket ( User Parents , Tickets Child )
        @ManyToOne
        @JoinColumn
        private User user ;


        // Many : One = Ticket : Show ( Ticket Child , Show Parents )
        @ManyToOne
        @JoinColumn
        private Show show ;


}
