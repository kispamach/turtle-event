package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.model.Event;
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
    public Event createEvent(@RequestBody Event newEvent) {
        newEvent.setCreateTime(LocalDateTime.now());
        eventService.saveEvent(newEvent);
        return newEvent;
    }

    @GetMapping("{id}")
    public Event getEventById(@PathVariable Long id) {
        return eventService.findEventById(id);
    }

    @DeleteMapping("{id}")
    public void deleteEventById(@PathVariable Long id) {
        Event event = eventService.findEventById(id);
        eventService.deleteEvent(event);
    }
}
