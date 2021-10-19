package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.model.dto.AddFriendDTO;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.model.dto.UserDTO;
import com.codecool.turtleevent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
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

    public RestResponseDTO saveUser(UserDTO userDTO){
        try {
            User user = new User();

            user.setUserName(userDTO.getUserName());
            user.setFirstName(userDTO.getFirstName());
            user.setLastName(userDTO.getLastName());
            user.setEmail(userDTO.getEmail());
            user.setPassword(userDTO.getPassword());
            user.setRegistered(LocalDateTime.now());
            userRepository.save(user);
            System.out.println("DTO true");
            return new RestResponseDTO(true, "Registration successful!");
        } catch (Exception e) {
            System.out.println("DTO false");
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
    public RestResponseDTO updateUser(UserDTO newUser){
        Optional<User> user = userRepository.findById(newUser.getId());
        if(user.isPresent()) {
            if(newUser.getUserName() != null) user.get().setUserName(newUser.getUserName());
            if(newUser.getFirstName() != null) user.get().setFirstName(newUser.getFirstName());
            if(newUser.getLastName() != null) user.get().setLastName(newUser.getLastName());
            if(newUser.getEmail() != null) user.get().setEmail(newUser.getEmail());
            if(newUser.getPassword() != null) user.get().setPassword(newUser.getPassword());
            return new RestResponseDTO(true, "User is up to date!");
        }
        return new RestResponseDTO(false, "User cannot be updated!");
    }

    @Transactional
    public RestResponseDTO addFriend(AddFriendDTO addFriendDTO){
        Optional<User> user = userRepository.findById(addFriendDTO.getUserId());
        Optional<User> friendUser = userRepository.findById(addFriendDTO.getFriendId());

        if(user.isPresent() && friendUser.isPresent()) {
            List<User> userFriends = user.get().getFriends();
            userFriends.add(friendUser.get());
            user.get().setFriends(userFriends);

            return new RestResponseDTO(true, "Friendship created!");
        }
        return new RestResponseDTO(false, "Friendship cannot be created!");

    }

}
