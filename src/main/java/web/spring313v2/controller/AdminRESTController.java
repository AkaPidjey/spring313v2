package web.spring313v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import web.spring313v2.DTO.UserDto;
import web.spring313v2.DTO.UserMapper;
import web.spring313v2.model.Role;
import web.spring313v2.model.User;
import web.spring313v2.service.UserService;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping(path = "/api")
public class AdminRESTController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public ResponseEntity<UserDto> getCurrentUser(Authentication authentication) {
        return new ResponseEntity<>(UserMapper.toDto(userService.getUserByLogin(authentication.getName()).get()),
                HttpStatus.OK);
    }

    @GetMapping("/admin")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(UserMapper.toDto(userService.getAllUsers()), HttpStatus.OK);
    }

    @GetMapping("/admin/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable("id") Long id) {
        return new ResponseEntity<>(UserMapper.toDto(userService.getUserById(id).get()), HttpStatus.OK);
    }

    @PostMapping("/admin/create")
    public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto userDto) {
        User user = UserMapper.toModel(userDto);
        user.setPasswordReal(user.getPassword());
        userService.createNewUser(user);
        return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.CREATED);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDto) {
        User user = UserMapper.toModel(userDto);
        userService.editUser(user);
        return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
    }

    @DeleteMapping("/admin/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }









//    @PutMapping("/admin/update")
//    public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDto) {
//        User user = UserMapper.toModel(userDto);
//        userService.editUser(user);
//        return ResponseEntity.ok().body(UserMapper.toDto(user));
//    }



}











//    @GetMapping("/getUser")
//    public ResponseEntity<UserDto> getCurrentUserInfo() {
//
//        return new ResponseEntity<>(UserMapper.toDto(
//                (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()), HttpStatus.OK);
//    }

//    @GetMapping("/getUser")
//    public ResponseEntity<UserDto> getCurrentUserInfo(Authentication authentication) {
//
//        return new ResponseEntity<>(UserMapper.toDto(
//                userService.getUserByLogin(authentication.getName()).get()), HttpStatus.OK);
//    }



//    @PostMapping("/admin/create")
//    public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto userDto,
//                                                 @RequestParam("role_1") String role) {
//        User user = UserMapper.toModel(userDto);
//        user.setPasswordReal(user.getPassword());
//        final Set<Role> roleSet = new HashSet<>();
//        if (role.equals("ROLE_ADMIN")) {
//            roleSet.add(userService.getRoleByName("ROLE_ADMIN").get());
//            roleSet.add(userService.getRoleByName("ROLE_USER").get());
//        } else {
//            roleSet.add(userService.getRoleByName("ROLE_USER").get());
//        }
//        user.setRoles(roleSet);
//        userService.createNewUser(user);
//        return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.CREATED);
//    }



//    @PutMapping("/admin/update")
//    public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDto,
//                                            @RequestParam("role_2") String role) {
//        User user = UserMapper.toModel(userDto);
//        final Set<Role> roleSet = new HashSet<>();
//        if (role.equals("ROLE_ADMIN")) {
//            roleSet.add(userService.getRoleByName("ROLE_ADMIN").get());
//            roleSet.add(userService.getRoleByName("ROLE_USER").get());
//        } else {
//            roleSet.add(userService.getRoleByName("ROLE_USER").get());
//        }
//        user.setRoles(roleSet);
//        userService.editUser(user);
//        return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
//    }


//    @DeleteMapping("/admin/delete")
//    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUserById(id);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }