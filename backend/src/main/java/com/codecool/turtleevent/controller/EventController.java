package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.model.Event;
import com.codecool.turtleevent.model.dto.EventIdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/event/")
public class EventController {

    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("all")
    public List<Event> getAllUsers(){
        return eventService.getAllEvent();
    }

    @PostMapping("create")
    public RestResponseDTO createEvent(@RequestBody Event newEvent) {
        return eventService.saveEvent(newEvent);
    }

    @GetMapping("find")
    public Event getEventById(@RequestBody EventIdDTO id) {
        return eventService.findEventById(id.getId());
    }

    @DeleteMapping("delete")
    public RestResponseDTO deleteEventById(@RequestBody EventIdDTO id) {
        return eventService.deleteEvent(id);
    }
}
