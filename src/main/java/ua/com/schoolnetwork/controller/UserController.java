package ua.com.schoolnetwork.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ua.com.schoolnetwork.dto.DtoUtilMapper;
import ua.com.schoolnetwork.dto.UserDto;
import ua.com.schoolnetwork.entity.User;
import ua.com.schoolnetwork.service.interfaces.UserService;

import java.security.Principal;

/**
 * Created by ваня on 12.02.2017.
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public String save(@ModelAttribute User user,Model model){
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            model.addAttribute("exception", e.getMessage()+"!!");
            return "views-base-registration";
        }
        return "views-base-home";
    }
    @PostMapping("/failLogin")
    public String failLogin(Model model, @RequestParam String email,
                            @RequestParam String password) {

        User user = userService.findByEmail(email);

        if (encoder.matches(user.getPassword(), password)) {
            return "redirect:/";
        }

        model.addAttribute("fail", "fail");

        return "views-base-loginpage";
    }
    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    public String userProfile(Model model, Principal principal){
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        UserDto userDto = DtoUtilMapper.userToUserDto(user);
        model.addAttribute("user",userDto);
        return "views-base-profile";
    }
    @RequestMapping(value = "/edit",method = RequestMethod.GET)
    public String editProfile(Principal principal,Model model){
        User user = userService.findOne(Integer.parseInt(principal.getName()));
        model.addAttribute("user", user);
        return "views-base-editProfile";
    }
    @RequestMapping(value = "/saveChanged", method = RequestMethod.POST)
    public String saveChanged(@ModelAttribute User user,Principal principal) {
        userService.changeUser(Integer.parseInt(principal.getName()),user);
        return "redirect:/profile";
    }
    @RequestMapping(value = "/saveProfileImage", method = RequestMethod.POST)
    public  String upadatePhoto(@RequestParam MultipartFile image, Principal principal){
        userService.saveProfileImage(image,Integer.parseInt(principal.getName()));
        return "redirect:/profile";
    }
    @RequestMapping(value = "/profile/{id}")
    public String profile(@PathVariable int id,Model model){
        model.addAttribute("user", DtoUtilMapper.userToUserDto(userService.findOne(id)));
        return "views-base-userProfile";
    }
}
