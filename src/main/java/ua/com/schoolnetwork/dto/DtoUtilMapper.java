package ua.com.schoolnetwork.dto;

import ua.com.schoolnetwork.entity.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ваня on 13.02.2017.
 */
public class DtoUtilMapper {

    public static List<UserDto> userToUserDto(List<User> users){
        List<UserDto> userDtos = new ArrayList<>();
        for (User user:users){
            UserDto userDto = new UserDto(user.getId(),user.getFirstName(),user.getSecondName(),
                    user.getAge(),user.getStatus(),user.getCity(),user.getPhoneNumber());
            userDtos.add(userDto);
        }
        return userDtos;
    }
    public static UserDto userToUserDto(User user){
        UserDto userDto = new UserDto(user.getId(),user.getFirstName(),user.getSecondName(),
                user.getAge(),user.getStatus(),user.getCity(),user.getPhoneNumber());
        return userDto;
    }
}
