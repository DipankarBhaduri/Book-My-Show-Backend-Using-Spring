package com.BookMyShow.Repositories;
import com.BookMyShow.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository <User, Integer > {

        // Find User by Name For updating Email :
        @Query( value = "select * from users where name=:userName" , nativeQuery = true)
        User findUserByName ( String userName);


        // Find User by User EmailId for updating User entity :
        @Query(value = "select * from users where email =:mail" , nativeQuery = true)
        User findUserByEmail ( String mail);

}
