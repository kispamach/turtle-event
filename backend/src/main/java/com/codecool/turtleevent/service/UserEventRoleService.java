package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.Event;
import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.model.UserEventRole;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.model.dto.UserEventRoleDTO;
import com.codecool.turtleevent.repository.UserEventRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
}
