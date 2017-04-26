package ua.com.schoolnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.entity.Dialog;
import ua.com.schoolnetwork.entity.Message;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.service.interfaces.UserService;

import java.security.Principal;

/**
 * Created by ваня on 05.02.2017.
 */
@Controller
public class HomeController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String home() {
        return "views-base-home";
    }

    @RequestMapping(value = "/home", method = RequestMethod.POST)
    public String loginprocesing() {
        return "views-base-home";
    }

    @RequestMapping("/loginpage")
    public String login() {
        return "views-base-loginpage";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        return "redirect:/loginpage";
    }

    @RequestMapping(value = "/registration",method = RequestMethod.GET)
    public String registration(Model model){
        model.addAttribute("user",new User());
        return "views-base-registration";
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public String getStudents(Model model, Principal principal){
        model.addAttribute("users", DtoUtilMapper.userToUserDto(userService.findAll()));
        return "views-base-friend";
    }
}
