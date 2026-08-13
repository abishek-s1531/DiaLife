package com.diabetic.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.diabetic.demo.entity.User;
import com.diabetic.demo.service.UserService;


@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private  UserService userService;

   
    @PostMapping("/add")
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @PostMapping("/add/{roleId}")
    public User saveUser(@PathVariable Long roleId, @RequestBody User user) {
        return userService.saveUser(roleId, user);
    }

   
    @GetMapping("/all")
    public List<User> getAllUser() {
        return userService.getAllUser();
    }

    
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

   
    @PutMapping("/update/{id}/{roleId}")
    public User updateUser(@PathVariable Long id,@PathVariable Long roleId,@RequestBody User user) {
        return userService.updateUser(user, id, roleId);
    }

   
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "User deleted successfully";
    }
}
