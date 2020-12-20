//package web.spring313v2.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import web.spring313v2.model.User;
//import web.spring313v2.service.UserService;
//
//@Controller
//public class ViewController {
//
//    private final UserService userService;
//
//    public ViewController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping
//    public String view(Model model, Authentication authentication) {
//        User currentUser = userService.getUserByLogin(authentication.getName()).get();
//        model.addAttribute("currentUser", currentUser);
//
//        if (currentUser.getRoles().size() > 1) {
//            return "adminPage";
//        } else {
//            return "userPage";
//        }
//    }
//}
