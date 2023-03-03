package com.BookMyShow.Entities;
import com.BookMyShow.Enums.ShowType;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table ( name = "shows")
public class Show {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY )
    private int id ;

    private LocalDate showDate ;

    private LocalTime showTime ;

    @Enumerated ( value = EnumType.STRING)
    private ShowType showType;

    @CreationTimestamp
    private Date createdOn ;

    @UpdateTimestamp
    private Date updatedOn ;


    // Many : One = Ticket : Show ( Ticket Child , Show Parents )
    @OneToMany( mappedBy = "show" , cascade = CascadeType.ALL)
    List< Ticket > ticketList = new ArrayList<>() ;


    // Many : One = Show : Theater ( Show Child , Theater Parents )
    @ManyToOne
    @JoinColumn
    private Theater theater ;


    // Many : One = Show : Movie ( Movie Parents , Show Child )
    @ManyToOne
    @JoinColumn
    private Movie movie ;


    // One : Many = Show : ShowSeat ( Show Parents , ShowSeat Child )
    @OneToMany( mappedBy = "show" , cascade = CascadeType.ALL)
    List< ShowSeat> showSeats = new ArrayList<>() ;

}
