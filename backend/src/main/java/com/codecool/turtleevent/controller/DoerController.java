package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.service.DoerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/doer/")
public class DoerController {

    private DoerService doerService;

    @Autowired
    public void setDoerService(DoerService doerService) {
        this.doerService = doerService;
    }
}
