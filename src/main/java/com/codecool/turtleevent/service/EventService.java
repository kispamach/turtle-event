package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.Event;
import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void saveEvent(Event event){
        eventRepository.save(event);
    }

    public void deleteEvent(Event event){
        eventRepository.delete(event);
    }

}
