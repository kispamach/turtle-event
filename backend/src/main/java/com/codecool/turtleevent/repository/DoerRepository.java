package com.codecool.turtleevent.repository;

import com.codecool.turtleevent.model.Doer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoerRepository extends JpaRepository<Doer, Long> {
}