package com.BookMyShow.DTOs;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserEntryDto {
    private String name ;
    private String email ;
    private int age ;
    private String mobNo ;
    private String address ;
}
