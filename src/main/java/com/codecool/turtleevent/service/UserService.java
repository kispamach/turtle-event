package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserById(Long id){
        return userRepository.findById(id);
    }

    public List<User> getAllUser(){
       return userRepository.findAll();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

}
