package com.BookMyShow.Services;
import com.BookMyShow.Convertors.UserConverter;
import com.BookMyShow.DTOs.UserEmailUpdateDto;
import com.BookMyShow.DTOs.UserEntryDto;
import com.BookMyShow.Entities.User;
import com.BookMyShow.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    @Autowired
    UserRepository userRepository ;

    @Autowired
    JavaMailSender javaMailSender;

    public String addUser (UserEntryDto userEntryDto ) throws Exception {
        User user = UserConverter.converDtoToUserEntity(userEntryDto);
        userRepository.save(user);
        return "User added successfully" ;

//        try {
//            String body = "Hi " + user.getName() + " , Welcome to book my show , Enjoy our services ";
//            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
//            mimeMessageHelper.setFrom("dipankarbhaduri8@gmail.com");
//            mimeMessageHelper.setTo(user.getEmail());
//            mimeMessageHelper.setText(body);
//            mimeMessageHelper.setSubject("Confirming your booked Ticket");
//            javaMailSender.send(mimeMessage);
//            return "Sending email" ;
//        } catch (Exception e) {
//            return e.getMessage();
//        }
    }




    // This Method is for only update Email to your DB :
    public String updateEmail (UserEmailUpdateDto userEmailUpdateDto){
        User user = userRepository.findUserByName ( userEmailUpdateDto.getName()) ;
        user.setEmail(userEmailUpdateDto.getEmail());
        userRepository.save(user) ;
        return user.getName()+" Email updated successfully" ;
    }



    // Update the exiting user :
    public String updateUser ( UserEntryDto userEntryDto ){
        User user = userRepository.findUserByEmail ( userEntryDto.getEmail()) ;
        if (userEntryDto.getAddress() != null){
            user.setAddress(userEntryDto.getAddress());
        }
        if (userEntryDto.getName() != null){
            user.setName(userEntryDto.getName());
        }
        if (userEntryDto.getMobNo() != null){
            user.setMobNo(userEntryDto.getMobNo());
        }
        if ( userEntryDto.getAge() != 0){
            user.setAge(userEntryDto.getAge());
        }
        userRepository.save(user) ;
        return "User details Updated" ;
    }
}





