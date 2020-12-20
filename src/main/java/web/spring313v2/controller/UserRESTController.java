//package web.spring313v2.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import web.spring313v2.DTO.UserDto;
//import web.spring313v2.DTO.UserMapper;
//import web.spring313v2.model.User;
//import web.spring313v2.service.UserService;
//
//
//@RestController
//public class UserRESTController {
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/user/about")
//    public ResponseEntity<User> userAbout() {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        return new ResponseEntity<>(user, HttpStatus.OK);
//    }
//
//}




//
//    @GetMapping("/currentUser")
//    public ResponseEntity<UserDto> getCurrentUser(Authentication authentication) {
//        return ResponseEntity.ok(UserMapper.toDto(userService.getUserByLogin(authentication.getName()).get()));
//    }
