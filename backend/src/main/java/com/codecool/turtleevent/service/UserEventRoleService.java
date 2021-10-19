package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.*;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.model.dto.UserEventRoleDTO;
import com.codecool.turtleevent.repository.UserEventRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserEventRoleService {

    private UserEventRoleRepository userEventRoleRepository;

    private EventService eventService;
    private UserService userService;

    @Autowired
    public void setUserEventRoleRepository(UserEventRoleRepository userEventRoleRepository) {
        this.userEventRoleRepository = userEventRoleRepository;
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<UserEventRole> getAllByEvent(IdDTO eventId) {
        Event event = eventService.findEventById(eventId.getId());
        return userEventRoleRepository.findAllByEvent(event);
    }

    public List<UserEventRole> getAllByUser(IdDTO userId) {
        User user = userService.findUserById(userId.getId());
        return userEventRoleRepository.findAllByUser(user);
    }

    public List<UserEventRole> getAll() {
        return userEventRoleRepository.findAll();
    }


    public RestResponseDTO addUserEventRole(UserEventRoleDTO userEventRole) {
        User user = userService.findUserById(userEventRole.getUserId());
        Event event = eventService.findEventById(userEventRole.getEventId());

        if(user != null && event != null) {
            userEventRoleRepository.save(new UserEventRole(user, event, userEventRole.getRoleType(), LocalDateTime.now()));
            return new RestResponseDTO(true, "User - event connection created!");
        }
        return new RestResponseDTO(false, "Failed to create User - event connection!");
    }

    public RestResponseDTO delete(Long id) {
        Optional<UserEventRole> userEventRole = userEventRoleRepository.findById(id);
        if(userEventRole.isPresent()) {
            userEventRoleRepository.delete(userEventRole.get());
            return new RestResponseDTO(true, "'User-Event-Role' deleted successfully!");
        }
        return new RestResponseDTO(false, "Failed to delete 'User-Event-Role'!");
    }

    public RestResponseDTO update(UserEventRole newUserEventRole) {
        Optional<UserEventRole> userEventRole = userEventRoleRepository.findById(newUserEventRole.getId());

        if (userEventRole.isPresent()) {
            try {
                userEventRole.get().setRole(newUserEventRole.getRole());
                return new RestResponseDTO(true, "The role update is successful");
            } catch (Exception e) {
                return new RestResponseDTO(false, "Not valid role type");
            }
        }
        return new RestResponseDTO(false, "Failed to update role type!");
    }
}
