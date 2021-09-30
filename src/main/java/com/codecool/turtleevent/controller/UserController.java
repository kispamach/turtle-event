package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user/")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "registration")
    public User registerUser(@RequestBody User newUser){
        newUser.setRegistered(LocalDateTime.now());
        userService.saveUser(newUser);
        System.out.println(newUser);
        return newUser;
    }

    @GetMapping("{id}")
    public Optional<User> getSendUser(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @GetMapping("allusers")
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }


}
