package ua.com.schoolnetwork.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by ваня on 05.02.2017.
 */
@Controller
public class HomeController {

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
}
