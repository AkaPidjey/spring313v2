package web.spring313v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import web.spring313v2.DTO.UserDto;
import web.spring313v2.DTO.UserMapper;
import web.spring313v2.model.Role;
import web.spring313v2.model.User;
import web.spring313v2.service.UserService;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
public class AdminRESTController {

    @Autowired
    private UserService userService;



    @GetMapping("/getUser")
    public ResponseEntity<UserDto> getCurrentUserInfo(Authentication authentication) {

        return new ResponseEntity<>(UserMapper.toDto(
                userService.getUserByLogin(authentication.getName()).get()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(UserMapper.toDto(userService.getUserById(id).get()), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        final List<User> allUsers = userService.getAllUsers();

        return allUsers != null && !allUsers.isEmpty()
                ? new ResponseEntity<>(allUsers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UserDto> createNewUser(@RequestBody UserDto userDto,
                                                 @RequestParam("role_1") String role) {
        User user = UserMapper.toModel(userDto);
        user.setPasswordReal(user.getPassword());
        final Set<Role> roleSet = new HashSet<>();
        if (role.equals("ROLE_ADMIN")){
            roleSet.add(userService.getRoleByName("ROLE_ADMIN").get());
            roleSet.add(userService.getRoleByName("ROLE_USER").get());
        } else {
            roleSet.add(userService.getRoleByName("ROLE_USER").get());
        }
        user.setRoles(roleSet);
        userService.createNewUser(user);
        return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDto,
                                      @RequestParam("role_2") String role) {
        User user = UserMapper.toModel(userDto);
        final Set<Role> roleSet = new HashSet<>();
        if (role.equals("ROLE_ADMIN")){
            roleSet.add(userService.getRoleByName("ROLE_ADMIN").get());
            roleSet.add(userService.getRoleByName("ROLE_USER").get());
        } else {
            roleSet.add(userService.getRoleByName("ROLE_USER").get());
        }
        user.setRoles(roleSet);
        userService.editUser(user);

        return new ResponseEntity<>(UserMapper.toDto(user), HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

}
