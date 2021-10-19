package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.Event;
import com.codecool.turtleevent.model.ToBring;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.repository.ToBringRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

    public ToBring findById(Long id){
        Optional<ToBring> toBring = toBringRepository.findById(id);
        return toBring.orElse(null);
    }

    public List<ToBring> getAll() {
        return toBringRepository.findAll();
    }


    public List<ToBring> getAllByEvent(IdDTO eventId) {
        Event event = eventService.findEventById(eventId.getId());
        if (event != null) return toBringRepository.findAllByEvent(event);
        return null;
    }


    public RestResponseDTO add(ToBring toBring) {
        try {
//            Event event = eventService.findEventById(toBring.getEvent());
            toBring.setCreateTime(LocalDateTime.now());
            toBring.setSubAmount(0);
            toBringRepository.save(toBring);
            return new RestResponseDTO(true, "'to bring' added successfully!");
        } catch (Exception e) {
            return new RestResponseDTO(false, "Failed to add!");
        }
    }


    @Transactional
    public RestResponseDTO update(ToBring newToBring) {
        Optional<ToBring> toBring = toBringRepository.findById(newToBring.getId());
        if(toBring.isPresent()) {
            if(newToBring.getTitle() != null) toBring.get().setTitle(newToBring.getTitle());
            if(newToBring.getComment() != null) toBring.get().setComment(newToBring.getComment());
            // Do we get null or 0?
            if(newToBring.getTotalAmount() != 0) toBring.get().setTotalAmount(newToBring.getTotalAmount());
            return new RestResponseDTO(true, "'To bring' updated!");
            }
        return new RestResponseDTO(false, "'To bring' failed to update!");
    }

    public RestResponseDTO delete(Long id) {
        Optional<ToBring> toBring = toBringRepository.findById(id);
        if(toBring.isPresent()) {
            toBringRepository.delete(toBring.get());
            return new RestResponseDTO(true, "'To bring' deleted successfully!");
        }
        return new RestResponseDTO(false, "Failed to delete 'To bring'!");
    }
}
