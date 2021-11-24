package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.model.Event;
import com.codecool.turtleevent.model.dto.EventDTO;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/event/")
public class EventController {

    private EventService eventService;

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("all")
    public List<EventDTO> getAllEvent(){
        return eventService.getAllEvent();
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("create")
    public RestResponseDTO createEvent(@RequestBody EventDTO newEvent) {
        return eventService.addEvent(newEvent);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping("{id}")
    public EventDTO getEventById(@PathVariable Long id) {
        return eventService.findEventDTOById(id);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @DeleteMapping("delete")
    public RestResponseDTO deleteEventById(@RequestBody IdDTO id) {
        return eventService.deleteEvent(id);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PutMapping("update")
    public RestResponseDTO updateEventById(@RequestBody EventDTO newEvent) {
        return eventService.updateEvent(newEvent);
    }

}
