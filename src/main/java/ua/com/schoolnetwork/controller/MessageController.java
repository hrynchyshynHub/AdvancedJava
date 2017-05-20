package ua.com.schoolnetwork.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.com.schoolnetwork.dto.MessageDto;
import ua.com.schoolnetwork.editor.DialogEditor;
import ua.com.schoolnetwork.editor.UserEditor;
import ua.com.schoolnetwork.entity.Dialog;
import ua.com.schoolnetwork.entity.Message;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.service.interfaces.DialogService;
import ua.com.schoolnetwork.service.interfaces.MessageService;
import ua.com.schoolnetwork.service.interfaces.UserService;

import java.security.Principal;
import java.time.LocalDate;

/**
 * Created by ваня on 22.04.2017.
 */
@Controller
public class MessageController {
    @Autowired
    private UserService userService;
    @Autowired
    private MessageService messageService;
    @Autowired
    private DialogService dialogService;

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String message(Model model, Principal principal){
        model.addAttribute("dialogs", dialogService.findUserDialogs(Integer.parseInt(principal.getName())));
        model.addAttribute("dialog", new Dialog());
        model.addAttribute("users", userService.findAllWithOutPrincipal(Integer.parseInt(principal.getName())));
        return "views-base-message";
    }

    @RequestMapping(value = "/createDialog" , method = RequestMethod.POST)
    public String createDialog(@RequestParam String name, @RequestParam int []usersId, Principal principal){
        dialogService.createDialog(principal,name,usersId);
        return "redirect:/message";
    }

    @GetMapping(value = "/im/{id}")
    public String test(@PathVariable int id,Model model){
        System.out.println("id is " + id);
        model.addAttribute("messages", messageService.findMessagesForDialog(id));
        return "views-base-im";
    }
    @RequestMapping(value = "/sendMessage/{id}", method = RequestMethod.POST)
    public String sendMessage(@RequestParam String message,Principal principal,@PathVariable int id){
        System.out.println("into send message");
        Message message1 = new Message();
        message1.setUserFrom(userService.findOne(Integer.parseInt(principal.getName())));
        message1.setDialog(dialogService.findOne(id));
        message1.setLocalDate(LocalDate.now());
        messageService.save(message1);
        return "redirect:/im/" + id;
    }

}
