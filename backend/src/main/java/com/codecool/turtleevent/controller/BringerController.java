package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.service.BringerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bringer/")
public class BringerController {

    private BringerService bringerService;

    @Autowired
    public void setBringerService(BringerService bringerService) {
        this.bringerService = bringerService;
    }
}
