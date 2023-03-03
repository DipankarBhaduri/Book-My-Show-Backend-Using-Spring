package com.BookMyShow.Entities;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Entity
@Table ( name = "users")
@Builder
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue ( strategy = GenerationType.IDENTITY)
    private int id ;

    private String name ;

    private String email ;

    private int age ;

    @Column ( unique = true , nullable = false )
    private String mobNo ;

    private String address ;

    // One : Many = User : Ticket ( User Parents , Tickets Child )
    @OneToMany ( mappedBy = "user" , cascade = CascadeType.ALL)
    List< Ticket > tickets = new ArrayList() ;
}
