package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.model.UserEventRole;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.model.dto.UserEventRoleDTO;
import com.codecool.turtleevent.service.UserEventRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user-event-role/")
public class UserEventRoleController {

    private UserEventRoleService userEventRoleService;

    @Autowired
    public void setUserEventRoleService(UserEventRoleService userEventRoleService) {
        this.userEventRoleService = userEventRoleService;
    }

    @GetMapping("all")
    public List<UserEventRole> getAll() {
        return userEventRoleService.getAll();
    }

    @GetMapping("by-event")
    public List<UserEventRole> userEventRoleByEvent(@RequestBody IdDTO eventId) {
        return userEventRoleService.getAllByEvent(eventId);
    }

    @GetMapping("by-user")
    public List<UserEventRole> userEventRoleByUser(@RequestBody IdDTO userId) {
        return userEventRoleService.getAllByUser(userId);
    }

    @PostMapping("add")
    public RestResponseDTO addUserEventRole(@RequestBody UserEventRoleDTO userEventRole) {
        return userEventRoleService.addUserEventRole(userEventRole);
    }


}
