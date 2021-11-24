package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.model.dto.AddFriendDTO;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.model.dto.UserDTO;
import com.codecool.turtleevent.service.UserService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/user/")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("profile/{id}")
    public UserDTO getUserById(@PathVariable Long id){
        return userService.findUserDTOById(id);
    }

    @PostMapping(value = "registration")
    public RestResponseDTO registerUser(@RequestBody UserDTO newUser){
        return userService.addUser(newUser);
    }

//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("all")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUser();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("delete")
    public RestResponseDTO deleteUserById(@RequestBody IdDTO user) {
        return userService.deleteUserById(user.getId());
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("update")
    public RestResponseDTO update(@RequestBody UserDTO newUser){
        return userService.updateUser(newUser);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("add-friend")
    public RestResponseDTO addFriend(@RequestBody AddFriendDTO addFriendDTO){
        return userService.addFriend(addFriendDTO);
    }

}
