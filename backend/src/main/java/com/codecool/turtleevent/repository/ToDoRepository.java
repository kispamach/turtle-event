package com.codecool.turtleevent.repository;

import com.codecool.turtleevent.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}