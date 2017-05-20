package ua.com.schoolnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.dto.MessageDto;
import ua.com.schoolnetwork.dto.UserEventDto;
import ua.com.schoolnetwork.entity.Message;
import ua.com.schoolnetwork.entity.UserEvent;
import ua.com.schoolnetwork.service.interfaces.DialogService;
import ua.com.schoolnetwork.service.interfaces.MessageService;
import ua.com.schoolnetwork.service.interfaces.UserEventService;
import ua.com.schoolnetwork.service.interfaces.UserService;

import javax.enterprise.inject.Produces;
import java.security.Principal;
import java.util.List;

/**
 * Created by ваня on 29.03.2017.
 */
@RestController
public class UserRestController{
    @Autowired
    private UserService userService;
    @Autowired
    private DialogService dialogService;
    @Autowired
    private UserEventService userEventService;
    @Autowired
    private MessageService  messageService;

    @RequestMapping(value = "profile/addToFriend" , method = RequestMethod.POST)
    public void addToFriend(@RequestBody String id, Principal principal){
        System.out.println("added id = " + id);
        userService.addToFriend(Integer.parseInt(id), Integer.parseInt(principal.getName()));
    }
    @RequestMapping(value = "/loadMessages", method = RequestMethod.POST)
    public @ResponseBody List<MessageDto> loadMessage(@RequestParam String dialogId){
        return DtoUtilMapper.messagesToMessageDtos(messageService.findMessagesForDialog(Integer.parseInt(dialogId)));
    }

    @RequestMapping(value = "/loadUserEvents", method = RequestMethod.POST)
    public @ResponseBody List<UserEventDto> loadUserEvent(@RequestBody String id){
        System.out.println("loading user event" + id);
        System.out.println(DtoUtilMapper.userEventToUserEventsDto(userEventService.findAll(Integer.parseInt(id))));
        return DtoUtilMapper.userEventToUserEventsDto(userEventService.findAll(Integer.parseInt(id)));
    }
    @RequestMapping(value = "/messageSend", method = RequestMethod.POST,
            consumes = MediaType.ALL_VALUE,
            produces = MediaType.ALL_VALUE,
            headers = "Accept=*/*")
    public void messageSend(@RequestBody MessageDto messageDto){
        System.out.println(messageDto + " message dto");
    }


}
