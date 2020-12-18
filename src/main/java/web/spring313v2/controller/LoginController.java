package web.spring313v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import web.spring313v2.model.User;
import web.spring313v2.service.UserService;

import java.util.Set;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }
//
//    @GetMapping(value = {"/admin"})
//    public String admin() {
//        return "admin";
//    }
//
//    @GetMapping(value = {"/user"})
//    public String user() {
//        return "user";
//    }

//    @GetMapping("/")
//    public String main(Model model, Authentication authentication) {
//        User currentUser = userService.getUserByLogin(authentication.getName()).get();
//        model.addAttribute("currentUser", currentUser);
//        return currentUser.getRoles().size() > 1 ? "admin" : "user";
//    }


    @GetMapping("/admin")
    public ModelAndView showUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("userLogin", user);
        return modelAndView;
    }

    @GetMapping("/user")
    public ModelAndView showAdmin() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("adminLogin", user);
        modelAndView.addObject(user);
        return modelAndView;
    }


}

