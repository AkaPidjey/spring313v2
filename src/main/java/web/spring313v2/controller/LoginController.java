package web.spring313v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import web.spring313v2.model.User;
import web.spring313v2.service.UserService;


@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/login"})
    public String login() {
        return "login";
    }

    @GetMapping("/user")
    public ModelAndView showUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

    @GetMapping("/admin")
    public ModelAndView showAdmin() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("admin");
        modelAndView.addObject("usersAll", userService.getAllUsers());
        modelAndView.addObject(user);
        return modelAndView;
    }

//    @GetMapping("/admin")
//    public ModelAndView getAllUsers() {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("adminBS");
//        modelAndView.addObject("users", userService.getAllUsers());
//        modelAndView.addObject(user);
//        return modelAndView;
//    }

//    @RequestMapping("/main")
//    public String getUser(Model model) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        model.addAttribute("user", user);
//        model.addAttribute("newUser", new User());
//        model.addAttribute("users", userService.getAllUsers());
//        return "main";
//    }

}
