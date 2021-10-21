package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.Event;
import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.model.dto.EventDTO;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.model.dto.UserDTO;
import com.codecool.turtleevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private EventRepository eventRepository;

    @Autowired
    public void setEventRepository(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    public Event findEventById(Long id){
        Optional<Event> event = eventRepository.findById(id);
        return event.orElse(null);
    }

    public List<Event> getAllEvent() {
        return eventRepository.findAll();
    }

    public RestResponseDTO addEvent(EventDTO event){
        try {
            Event newEvent = new Event();
            newEvent.setLocation(event.getLocation());
            newEvent.setName(event.getName());
            newEvent.setDescription(event.getDescription());
            newEvent.setFromDate(event.getFromDate());
            newEvent.setToDate(event.getToDate());
            newEvent.setCreateTime(LocalDateTime.now());

            eventRepository.save(newEvent);
            return new RestResponseDTO(true, "Event created!");
        } catch (Exception e) {
            return new RestResponseDTO(false, "Event cannot be created!");
        }
    }

    public RestResponseDTO deleteEvent(IdDTO id){
        Optional<Event> event = eventRepository.findById(id.getId());
        if(event.isPresent()) {
            eventRepository.delete(event.get());
            return new RestResponseDTO(true, "Event deleted!");
        }
        return new RestResponseDTO(false, "Event cannot be deleted!");
    }

    @Transactional
    public RestResponseDTO updateEvent(EventDTO newEvent){
        Optional<Event> event = eventRepository.findById(newEvent.getId());
        if(event.isPresent()) {
            if(newEvent.getName() != null) event.get().setName(newEvent.getName());
            if(newEvent.getDescription() != null) event.get().setDescription(newEvent.getDescription());
            if(newEvent.getLocation() != null) event.get().setLocation(newEvent.getLocation());
            if(newEvent.getFromDate() != null) event.get().setFromDate(newEvent.getFromDate());
            if(newEvent.getToDate() != null) event.get().setToDate(newEvent.getToDate());
            return new RestResponseDTO(true, "Event is up to date!");
        }
        return new RestResponseDTO(false, "Event cannot be updated!");
    }

}
