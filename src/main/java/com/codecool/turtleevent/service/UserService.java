package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.repository.UserRepository;
import com.sun.xml.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    public void saveUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(User user){
        userRepository.delete(user);
    }

    @Transactional
    public void updateUser(User newUser, Long id){
        User user = findUserById(id);
        user.setUserName(newUser.getUserName());
        user.setFirstName(newUser.getFirstName());
        user.setLastName(newUser.getLastName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());
    }

    @Transactional
    public void addFriend(Long userId, Long friendId){
        User user = findUserById(userId);
        User friend = findUserById(friendId);

        List<User> userFriends = user.getFriends();
        userFriends.add(friend);
        user.setFriends(userFriends);

        List<User> friendFriends = friend.getFriends();
        friendFriends.add(friend);
        friend.setFriends(friendFriends);
    }

}
