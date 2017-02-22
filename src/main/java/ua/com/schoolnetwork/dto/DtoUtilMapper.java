package ua.com.schoolnetwork.dto;

import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.entity.UserEvent;

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
    public static List<UserEventDto> userEventToUserEventsDto(List<UserEvent>userEvents){
        List<UserEventDto> userEventDtos = new ArrayList<>();
        for (UserEvent userEvent:userEvents){
            UserEventDto userEventDto = new UserEventDto(userEvent.getId(),userEvent.getDescription(),userEvent.getLocalDate(),userEvent.getLikeCounter());
            userEventDtos.add(userEventDto);
        }
        return userEventDtos;

    }
}
