package ua.com.schoolnetwork.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.editor.DialogEditor;
import ua.com.schoolnetwork.editor.UserEditor;
import ua.com.schoolnetwork.entity.Dialog;
import ua.com.schoolnetwork.entity.Message;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.service.interfaces.DialogService;
import ua.com.schoolnetwork.service.interfaces.MessageService;
import ua.com.schoolnetwork.service.interfaces.UserService;

import java.security.Principal;

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

    @InitBinder
    public void InitBinder(WebDataBinder binder){
        binder.registerCustomEditor(User.class,new UserEditor(userService));
        binder.registerCustomEditor(Dialog.class, new DialogEditor(dialogService));
    }

    @RequestMapping(value = "/message", method = RequestMethod.GET)
    public String message(Model model, Principal principal){
        model.addAttribute("dialogs", dialogService.findUserDialogs(Integer.parseInt(principal.getName())));
        model.addAttribute("dialog", new Dialog());
        model.addAttribute("users", userService.findAll());
        return "views-base-message";
    }

    @RequestMapping(value = "/createDialog" , method = RequestMethod.POST)
    public String createDialog(@RequestParam String name, @RequestParam int []usersId){
        dialogService.createDialog(name,usersId);
        return "redirect:/message";
    }
    @RequestMapping(value = "im/{id}", method = RequestMethod.GET)
    public String im(@PathVariable int id,Model model){
        model.addAttribute("messages", messageService.findMessagesForDialog(id));
        return "views-base-im";
    }

}
