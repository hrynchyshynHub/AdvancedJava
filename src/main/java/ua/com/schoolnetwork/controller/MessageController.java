package ua.com.schoolnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.dto.MessageDto;
import ua.com.schoolnetwork.service.MessageService;
import ua.com.schoolnetwork.service.UserService;

import java.security.Principal;
import java.util.List;

/**
 * Created by ваня on 04.03.2017.
 */
@RestController
public class MessageController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;

    @RequestMapping(value = "/loadMessage", method = RequestMethod.POST)
    public @ResponseBody
    List<MessageDto> loadMessage(Principal principal){
        return DtoUtilMapper.messagesToMessageDtos(messageService.
                findInboxMessageForUser(Integer.parseInt(principal.getName())));
    }
}
