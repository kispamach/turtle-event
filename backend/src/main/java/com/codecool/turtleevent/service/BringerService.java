package com.codecool.turtleevent.service;

import com.codecool.turtleevent.model.Bringer;
import com.codecool.turtleevent.model.ToBring;
import com.codecool.turtleevent.model.User;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.repository.BringerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class BringerService {

    private BringerRepository bringerRepository;
    private ToBringService toBringService;
    private UserService userService;

    @Autowired
    public void setBringerRepository(BringerRepository bringerRepository) {
        this.bringerRepository = bringerRepository;
    }

    @Autowired
    public void setToBringService(ToBringService toBringService) {
        this.toBringService = toBringService;
    }

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public List<Bringer> getAll() {
        return bringerRepository.findAll();
    }

    public List<Bringer> getAllByToBring(Long id) {
        ToBring toBring = toBringService.findById(id);
        return bringerRepository.findAllByToBring(toBring);

    }

    public List<Bringer> getAllByUser(Long userId) {
        User user = userService.findUserById(userId);
        return bringerRepository.findAllByUser(user);
    }

    public RestResponseDTO add(Bringer bringer) {
        try {
            bringer.setCreateTime(LocalDateTime.now());
            bringerRepository.save(bringer);
            bringer.getToBring().setSubAmount(bringer.getToBring().getSubAmount() + bringer.getAmount());
            return new RestResponseDTO(true, "Registration successful!");
        } catch (Exception e) {
            return new RestResponseDTO(false, "Registration failed!");
        }
    }

    @Transactional
    public RestResponseDTO update(Bringer newBringer) {
        Optional<Bringer> bringer = bringerRepository.findById(newBringer.getId());
        if (bringer.isPresent()) {
            if (newBringer.getAmount() != 0) bringer.get().setAmount(newBringer.getAmount());
            if (newBringer.getPrice() != 0) bringer.get().setPrice(newBringer.getPrice());
            if (newBringer.getAttachment() != null) bringer.get().setAttachment(newBringer.getAttachment());
            return new RestResponseDTO(true, "Bringer updated successfully!");
        }
        return new RestResponseDTO(false, "Bringer failed to update!");
    }

    @Transactional
    public RestResponseDTO increaseAmount(IdDTO bringerId) {
        Bringer bringer = bringerRepository.findById(bringerId.getId()).orElse(null);
        if (bringer != null){
            if (bringer.getToBring().getSubAmount() < bringer.getToBring().getTotalAmount()) {
                bringer.setAmount(bringer.getAmount() + 1);
                bringer.getToBring().setSubAmount(bringer.getToBring().getSubAmount() + 1);
                return new RestResponseDTO(true, "Increased amount by 1.");
            }
        }
        return new RestResponseDTO(false, "Can't increase amount.");
    }

    @Transactional
    public RestResponseDTO decreaseAmount(IdDTO bringerId) {
        Bringer bringer = bringerRepository.findById(bringerId.getId()).orElse(null);
        if (bringer != null){
            if (bringer.getToBring().getSubAmount() > 0)
            bringer.setAmount(bringer.getAmount() - 1);
            bringer.getToBring().setSubAmount(bringer.getToBring().getSubAmount() - 1);
            return new RestResponseDTO(true, "Decreased amount by 1.");
        }
        return new RestResponseDTO(false, "Can't decrease amount.");
    }

    @Transactional
    public RestResponseDTO changeAmount(IdDTO bringerId, int amount) {
        Bringer bringer = bringerRepository.findById(bringerId.getId()).orElse(null);
        if (bringer != null){
            if (bringer.getToBring().getSubAmount() - bringer.getAmount() + amount >= 0
                && bringer.getToBring().getSubAmount() - bringer.getAmount() + amount <= bringer.getToBring().getTotalAmount()) {
                bringer.setAmount(amount);
                bringer.getToBring().setSubAmount(bringer.getToBring().getSubAmount() - bringer.getAmount() + amount);
                return new RestResponseDTO(true, "Amount set.");
            }
        }
        return new RestResponseDTO(false, "Amount can't be set.");
    }



}
