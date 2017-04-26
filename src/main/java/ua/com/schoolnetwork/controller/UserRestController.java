package ua.com.schoolnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.dto.MessageDto;
import ua.com.schoolnetwork.entity.Message;
import ua.com.schoolnetwork.service.interfaces.DialogService;
import ua.com.schoolnetwork.service.interfaces.MessageService;
import ua.com.schoolnetwork.service.interfaces.UserService;

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
    private MessageService  messageService;

    @RequestMapping(value = "profile/addToFriend" , method = RequestMethod.POST)
    public void addToFriend(@RequestBody String id, Principal principal){
        System.out.println("added id = " + id);
        userService.addToFriend(Integer.parseInt(id), Integer.parseInt(principal.getName()));
    }
    @RequestMapping(value = "loadMessages", method = RequestMethod.POST)
    public @ResponseBody List<MessageDto> loadMessage(@RequestParam String dialogId){
        return DtoUtilMapper.messagesToMessageDtos(messageService.findMessagesForDialog(Integer.parseInt(dialogId)));
    }
    @RequestMapping(value = "/sendMessage/dialogID={id}", method = RequestMethod.POST)
    public @ResponseBody MessageDto sendMessage(Message message,Principal principal,@PathVariable String id){
        message.setUserFrom(userService.findOne(Integer.parseInt(principal.getName())));
        messageService.addMessageToDialog(message,Integer.parseInt(id));
        return DtoUtilMapper.messageToMessageDto(message);
    }

}