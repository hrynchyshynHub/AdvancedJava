package ua.com.schoolnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.dto.UserEventDto;
import ua.com.schoolnetwork.entity.UserEvent;
import ua.com.schoolnetwork.service.UserEventService;

import java.security.Principal;
import java.util.List;

/**
 * Created by ваня on 22.02.2017.
 */
@RestController
public class UserEventController {
    @Autowired
    private UserEventService userEventService;

    @RequestMapping(value = "/savePost", method = RequestMethod.POST)
    public @ResponseBody
    List<UserEventDto> savePost(@RequestBody UserEvent userEvent, Principal principal){
        userEventService.save(userEvent,Integer.parseInt(principal.getName()));
        return DtoUtilMapper.userEventToUserEventsDto(userEventService.findAll());
    }
    @RequestMapping(value = "/loadUserEvent", method = RequestMethod.POST)
    public @ResponseBody
    List<UserEventDto> loadUserEvent(Principal principal){
        return DtoUtilMapper.userEventToUserEventsDto(userEventService.findAll(Integer.parseInt(principal.getName())));
    }
    @RequestMapping(value = "/deleteUserEvent", method = RequestMethod.POST)
    public @ResponseBody
    List<UserEventDto> deleteUserEvent(@RequestBody String index,Principal principal){
        userEventService.delete(Integer.parseInt(index));
        return DtoUtilMapper.userEventToUserEventsDto(userEventService.findAll(Integer.parseInt(principal.getName())));
    }
}
