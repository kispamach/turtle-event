package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.model.Event;
import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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

    @GetMapping("{id}")
    @JsonView(User.UserView.class)
    public User getUserById(@PathVariable Long id){
        return userService.findUserById(id);
    }

    @PostMapping(value = "registration")
    @JsonView(User.UserView.class)
    public User registerUser(@RequestBody User newUser){
        newUser.setRegistered(LocalDateTime.now());
        userService.saveUser(newUser);
        return newUser;
    }

    @GetMapping("all")
    @JsonView(User.AllUsersView.class)
    public List<User> getAllUsers(){
        return userService.getAllUser();
    }

    @DeleteMapping("{id}")
    public void deleteUserById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        userService.deleteUser(user);
    }

    @PutMapping("update/{id}")
    public void update(@RequestBody User newUser, @PathVariable Long id){
        userService.updateUser(newUser, id);
    }

    @PutMapping("{id}/add-friend/{my_id}")
    public void update(@PathVariable Long my_id, @PathVariable Long id){
        userService.addFriend(id, my_id);
    }



}
