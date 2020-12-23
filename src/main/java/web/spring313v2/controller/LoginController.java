//package web.spring313v2.controller;
//
//import org.springframework.security.core.Authentication;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import web.spring313v2.model.User;
//import web.spring313v2.service.UserService;
//
//
//
//@Controller
//public class LoginController {
//
//    private final UserService userService;
//
//    public LoginController(UserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping(value = {"/", "/login"})
//    public String login() {
//        return "login";
//    }
//
//    @GetMapping(value = {"/admin"})
//    public String admin() {
//        return "adminPage";
//    }
//
//    @GetMapping(value = {"/user"})
//    public String user() {
//        return "userPage";
//    }
//}

//    @GetMapping
//    public String user(Model model, Authentication authentication) {
//        User currentUser = userService.getUserByLogin(authentication.getName()).get();
//        model.addAttribute("currentUser", currentUser);
//        if (currentUser.getRoles().size() > 1) {
//            return "adminPage";
//        } else {
//            return "userPage";
//        }
//    }
//}

//}
//    @GetMapping("/")
//    public Model getUser(Model model){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        model.addAttribute("currentUser", user);
//        return model;
//    }


//    @RequestMapping("/main")
//    public String getUser(Model model) {
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();
//        model.addAttribute("user", user);
//        if (user.getRoles().size() > 1) {
//            return "adminPage" ;
//        } else {
//            return "userPage";
//        }
//
//    }


//    @GetMapping("/user")
//    public ModelAndView showUser() {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("user");
//        modelAndView.addObject("userLogin", user);
//        return modelAndView;
//    }
//
//    @GetMapping("/admin")
//    public ModelAndView showAdmin() {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("admin");
//        modelAndView.addObject("adminLogin", user);
//        modelAndView.addObject(user);
//        return modelAndView;
//    }

//    @GetMapping("/api")
//    public ModelAndView main() {
//        ModelAndView modelAndView = new ModelAndView();
//        User currentUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        modelAndView.addObject("currentUser", currentUser);
//        if (currentUser.getRoles().size() > 1) {
//            modelAndView.setViewName("adminPage");
//            return modelAndView;
//        } else {
//            modelAndView.setViewName("userPage");
//            return modelAndView;
//        }
//    }

    //
//import org.springframework.web.bind.annotation.GetMapping;
//

//
//
//
//
//}