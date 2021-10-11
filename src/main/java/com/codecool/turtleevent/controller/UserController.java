package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/user/")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("profile")
    @JsonView(User.UserView.class)
    public User getUserById(@RequestBody User user){
        return userService.findUserById(user.getId());
    }

    @PostMapping(value = "registration")
    @JsonView(User.UserView.class)
    public RestResponseDTO registerUser(@RequestBody User newUser){
        return userService.saveUser(newUser);
    }

    @GetMapping("all")
    @JsonView(User.AllUsersView.class)
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @DeleteMapping("delete")
    public RestResponseDTO deleteUserById(@RequestBody User user) {
        return userService.deleteUserById(user.getId());
    }

    @PutMapping("update")
    public RestResponseDTO update(@RequestBody User newUser){
        return userService.updateUser(newUser);
    }

    @PutMapping("add-friend")
    public RestResponseDTO addFriend(@RequestBody User user, @RequestBody User friendUser){
        return userService.addFriend(user, friendUser);
    }



}
