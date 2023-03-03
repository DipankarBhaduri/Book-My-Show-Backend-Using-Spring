package com.BookMyShow.Convertors;
import com.BookMyShow.DTOs.ShowDto;
import com.BookMyShow.Entities.Show;
import lombok.Data;

@Data
public class ShowConverter {

    public static Show convertShowDtotoShow ( ShowDto showDto ){
        Show show = Show.builder()
                .showTime(showDto.getShowTime())
                .showDate(showDto.getShowDate())
                .showType(showDto.getShowType())
                .build();

        return show ;
    }
}
