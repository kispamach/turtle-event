package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.model.ToBring;
import com.codecool.turtleevent.model.UserEventRole;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.service.ToBringService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/to-bring/")
public class ToBringController {

    private ToBringService toBringService;

    @Autowired
    public void setToBringService(ToBringService toBringService) {
        this.toBringService = toBringService;
    }

    @GetMapping("all")
    public List<ToBring> getAll() {
        return toBringService.getAll();
    }

    @GetMapping("by-event")
    public List<ToBring> getAllByEvent(@RequestBody IdDTO eventId) {
        return toBringService.getAllByEvent(eventId);
    }

    @GetMapping("by-bringer")
    public List<ToBring> getAllByUser(@RequestBody IdDTO bringerId) {
        return toBringService.getAllByBringer(userId);
    }
}
