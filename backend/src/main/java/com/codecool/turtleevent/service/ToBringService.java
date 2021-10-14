package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.Event;
import com.codecool.turtleevent.model.ToBring;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.repository.ToBringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToBringService {

    private ToBringRepository toBringRepository;

    private EventService eventService;
    private BringerService bringerService;

    @Autowired
    public void setToBringRepository(ToBringRepository toBringRepository) {
        this.toBringRepository = toBringRepository;
    }

    @Autowired
    public void setEventService(EventService eventService) {
        this.eventService = eventService;
    }

    @Autowired
    public void setBringerService(BringerService bringerService) {
        this.bringerService = bringerService;
    }

    public List<ToBring> getAll() {
        return toBringRepository.findAll();
    }


    public List<ToBring> getAllByEvent(IdDTO eventId) {
        Event event = eventService.findEventById(eventId.getId());
        if (event != null) return toBringRepository.findAllByEvent(event);
        return null;
    }
}
