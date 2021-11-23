package com.codecool.turtleevent.repository;

import com.codecool.turtleevent.model.ERole;
import com.codecool.turtleevent.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByName(ERole name);

}
