package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.Event;
import com.codecool.turtleevent.model.dto.EventIdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public RestResponseDTO saveEvent(Event event){
        try {
            event.setCreateTime(LocalDateTime.now());
            eventRepository.save(event);
            return new RestResponseDTO(true, "Event created!");
        } catch (Exception e) {
            return new RestResponseDTO(false, "Event cannot be created!");
        }
    }

    public RestResponseDTO deleteEvent(EventIdDTO id){
        Optional<Event> event = eventRepository.findById(id.getId());
        if(event.isPresent()) {
            eventRepository.delete(event.get());
            return new RestResponseDTO(true, "Event deleted!");
        }
        return new RestResponseDTO(false, "Event cannot be deleted!");
    }

}
