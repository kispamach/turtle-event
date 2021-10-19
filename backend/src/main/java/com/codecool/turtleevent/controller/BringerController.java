package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.model.Bringer;
import com.codecool.turtleevent.model.ToBring;
import com.codecool.turtleevent.model.dto.IdDTO;
import com.codecool.turtleevent.model.dto.RestResponseDTO;
import com.codecool.turtleevent.service.BringerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bringer/")
public class BringerController {

    private BringerService bringerService;

    @Autowired
    public void setBringerService(BringerService bringerService) {
        this.bringerService = bringerService;
    }

    @GetMapping("all")
    public List<Bringer> getAll() {
        return bringerService.getAll();
    }

    @GetMapping("by-to-bring")
    public List<Bringer> getAllByToBring(@RequestBody IdDTO toBringId) {
        return bringerService.getAllByToBring(toBringId.getId());
    }

    @GetMapping("by-user")
    public List<Bringer> getAllByUser(@RequestBody IdDTO userId) {
        return bringerService.getAllByUser(userId.getId());
    }

    @PostMapping("add")
    public RestResponseDTO addBringer(@RequestBody Bringer bringer) {
        return bringerService.add(bringer);
    }

    @PutMapping("increase-amount")
    public  RestResponseDTO increaseAmount(@RequestBody IdDTO id) {
        return bringerService.increaseAmount(id);
    }

    @PutMapping("decrease-amount")
    public  RestResponseDTO decreaseAmount(@RequestBody IdDTO id) {
        return bringerService.decreaseAmount(id);
    }

    @PutMapping("set-amount")
    public  RestResponseDTO setAmount(@RequestBody IdDTO id, @RequestBody int amount) {
        return bringerService.changeAmount(id, amount);
    }


//    @PutMapping("update")
//    public RestResponseDTO updateToBring(@RequestBody ToBring toBring) {
//        return toBringService.update(toBring);
//    }
//
//    @DeleteMapping("delete")
//    public RestResponseDTO deleteToBring(@RequestBody IdDTO id) {
//        return toBringService.delete(id.getId());
//    }
}
