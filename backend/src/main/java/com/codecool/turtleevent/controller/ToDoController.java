package com.codecool.turtleevent.controller;

import com.codecool.turtleevent.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/to-do/")
public class ToDoController {

    private ToDoService toDoService;

    @Autowired
    public void setToDoService(ToDoService toDoService) {
        this.toDoService = toDoService;
    }
}
