package web.spring313v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import web.spring313v2.model.Role;
import web.spring313v2.model.User;
import web.spring313v2.service.UserService;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api")
public class AdminRESTController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) {

        return new ResponseEntity<>(userService.getUserById(id).get(), HttpStatus.OK);
    }


//    @GetMapping("/users/{id}")
//    public ResponseEntity<User> getUserById(@ModelAttribute User user,
//                                            @PathVariable("id") Long id) {
//        final User newUser = userService.getUserById(id).get();
//        newUser.setRoles(user.getRoles());
//
//        return new ResponseEntity<>(newUser, HttpStatus.OK);
//
//    }

    @GetMapping("/admin")
    public ResponseEntity<List<User>> getAllUsers() {
        final List<User> allUsers = userService.getAllUsers();

        return allUsers != null && !allUsers.isEmpty()
                ? new ResponseEntity<>(allUsers, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/admin")
    public ResponseEntity<?> createNewUser(@RequestBody User user,
                                           @RequestParam("role_1") String role) {
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

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/admin")
    public ResponseEntity<?> editUser(@RequestBody User user,
                                      @RequestParam("role_2") String role) {
        final Set<Role> roleSet = new HashSet<>();
        if (role.equals("ROLE_ADMIN")){
            roleSet.add(userService.getRoleByName("ROLE_ADMIN").get());
            roleSet.add(userService.getRoleByName("ROLE_USER").get());
        } else {
            roleSet.add(userService.getRoleByName("ROLE_USER").get());
        }
        user.setRoles(roleSet);
        userService.editUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/admin/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }






//    @PutMapping("/admin")
//    public void editUser(@ModelAttribute("user") User user, @RequestParam("role_2") String role) {
//        Set<Role> roleSet = new HashSet<>();
//        if (role.equals("ROLE_ADMIN")){
//            roleSet.add(userService.getRoleByName("ROLE_ADMIN").get());
//            roleSet.add(userService.getRoleByName("ROLE_USER").get());
//        } else {
//            roleSet.add(userService.getRoleByName("ROLE_USER").get());
//        }
//        user.setRoles(roleSet);
//        userService.editUser(user);
//    }
//
//    @DeleteMapping("/admin/{id}")
//    public void deleteUser(@PathVariable("id") Long id) {
//        userService.deleteUserById(id);
//    }



//    @PostMapping("/users")
//    public void createNewUser(@ModelAttribute("user") User user, @RequestParam("role_1") String role) {
//        user.setPasswordReal(user.getPassword());
//        Set<Role> roleSet = new HashSet<>();
//        if (role.equals("ROLE_ADMIN")){
//            roleSet.add(userService.getRoleByName("ROLE_ADMIN").get());
//            roleSet.add(userService.getRoleByName("ROLE_USER").get());
//        } else {
//            roleSet.add(userService.getRoleByName("ROLE_USER").get());
//        }
//        user.setRoles(roleSet);
//        userService.createNewUser(user);
//    }


}
