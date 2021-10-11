package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.repository.UserRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        return user.orElse(null);
    }

    public List<User> getAllUser(){
       return userRepository.findAll();
    }

    public RestResponseDTO saveUser(User user){
        try {
            user.setRegistered(LocalDateTime.now());
            userRepository.save(user);
            return new RestResponseDTO(true, "Registration successful!");
        } catch (Exception e) {
            return new RestResponseDTO(false, "Registration failed!");
        }
    }

    public RestResponseDTO deleteUserById(Long id){
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            userRepository.delete(user.get());
            return new RestResponseDTO(true, "User deleted!");
        }
        return new RestResponseDTO(false, "User can't be deleted!");
    }

    @Transactional
    public RestResponseDTO updateUser(User newUser){
        Optional<User> user = userRepository.findById(newUser.getId());
        if(user.isPresent()) {
            user.get().setUserName(newUser.getUserName());
            user.get().setFirstName(newUser.getFirstName());
            user.get().setLastName(newUser.getLastName());
            user.get().setEmail(newUser.getEmail());
            user.get().setPassword(newUser.getPassword());
            return new RestResponseDTO(true, "User up to date!");
        }
        return new RestResponseDTO(false, "User cannot be updated!");
    }

    @Transactional
    public RestResponseDTO addFriend(User user1, User user2){
        Optional<User> user = userRepository.findById(user1.getId());
        Optional<User> friendUser = userRepository.findById(user2.getId());

        if(user.isPresent() && friendUser.isPresent()) {
            List<User> userFriends = user.get().getFriends();
            userFriends.add(friendUser.get());
            user.get().setFriends(userFriends);

            List<User> friendFriends = friendUser.get().getFriends();
            friendFriends.add(user.get());
            friendUser.get().setFriends(friendFriends);

            return new RestResponseDTO(true, "Friendship created!");
        }
        return new RestResponseDTO(false, "Friendship cannot be created!");

    }

}
