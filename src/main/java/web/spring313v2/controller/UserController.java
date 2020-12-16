//package web.spring313v2.controller;
//
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.servlet.ModelAndView;
//import web.spring313v2.model.User;
//
//
//@Controller
//public class UserController {
//
//    @GetMapping("/user")
//    public ModelAndView showUser() {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("user");
//        modelAndView.addObject("user", user);
//        return modelAndView;
//    }
//
//}
