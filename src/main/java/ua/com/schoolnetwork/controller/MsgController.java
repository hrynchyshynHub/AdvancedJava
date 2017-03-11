package ua.com.schoolnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.schoolnetwork.entity.Message;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.service.MessageService;
import ua.com.schoolnetwork.service.UserService;

import java.security.Principal;

/**
 * Created by ваня on 08.03.2017.
 */
@Controller
public class MsgController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/sendMessage" , method = RequestMethod.POST)
    public String sendMesage(@RequestParam String idUserTo, @RequestParam String message,Principal principal){
        Message message1 = new Message();
        message1.setMessage(message);
        messageService.save(message1,Integer.parseInt(idUserTo), Integer.parseInt(principal.getName()));
        return "redirect:/message";
    }
    @RequestMapping(value = "/im/{id}", method = RequestMethod.GET)
    public String im(Model model, @PathVariable String id){
       // model.addAttribute("messages", messageService.findDialog(Integer.parseInt(id)));
        return "views-base-dialog";
    }
}
