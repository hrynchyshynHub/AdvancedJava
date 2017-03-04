package ua.com.schoolnetwork.dto;

import ua.com.schoolnetwork.entity.Comments;
import ua.com.schoolnetwork.entity.Message;
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
                    user.getAge(),user.getStatus(),user.getCity(),user.getPhoneNumber(),user.getEmail());
            userDtos.add(userDto);
        }
        return userDtos;
    }
    public static UserDto userToUserDto(User user){
        UserDto userDto = new UserDto(user.getId(),user.getFirstName(),user.getSecondName(),
                user.getAge(),user.getStatus(),user.getCity(),user.getPhoneNumber(),user.getEmail());
        return userDto;
    }
    public static List<UserEventDto> userEventToUserEventsDto(List<UserEvent>userEvents){
        List<UserEventDto> userEventDtos = new ArrayList<>();
        for (UserEvent userEvent:userEvents){
            UserEventDto userEventDto = new UserEventDto(userEvent.getId(),userEvent.getDescription(),userEvent.getLocalDate(),userEvent.getLikeCounter(),userEvent.getUser().getFirstName(), userEvent.getUser().getSecondName(),userEvent.getPathToImage());
            userEventDtos.add(userEventDto);
        }
        return userEventDtos;

    }
    public static UserEventDto userEventToUserEventDto(UserEvent userEvent){
        UserEventDto userEventDto =  new UserEventDto(userEvent.getId(),userEvent.getDescription(),userEvent.getLocalDate(),userEvent.getLikeCounter(),userEvent.getUser().getFirstName(), userEvent.getUser().getSecondName(),userEvent.getPathToImage());
        return userEventDto;
    }
    public static List<CommentsDto> commentsToComentsDto(List<Comments> commentses){
        List<CommentsDto> commentsDtos = new ArrayList<CommentsDto>();
        for(Comments comments:commentses){
            CommentsDto commentsDto = new CommentsDto(comments.getId(),comments.getComment(),comments.getLocalDate(),comments.getUser().getFirstName(),comments.getUser().getSecondName());
            commentsDtos.add(commentsDto);
        }
        return commentsDtos;
    }
    public static MessageDto messageToMessageDto(Message message){
        String userName = message.getUserFrom().getFirstName() + message.getUserFrom().getSecondName();
        MessageDto messageDto = new MessageDto(message.getId(),message.getMessage(),message.isReading(),userName);
        return messageDto;
    }
    public static List<MessageDto> messagesToMessageDtos(List<Message> message){
        List<MessageDto> messageDtos = new ArrayList<>();
        for(Message message1:message){
        String userName = message1.getUserFrom().getFirstName() + message1.getUserFrom().getSecondName();
        MessageDto messageDto = new MessageDto(message1.getId(),message1.getMessage(),message1.isReading(),userName);
            messageDtos.add(messageDto);
        }
        return messageDtos;
    }
}
