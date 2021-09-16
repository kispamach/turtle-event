package com.codecool.turtleevent.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="roles")
public class Role {
    @Id
    @GeneratedValue
    private Long id;
    private String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>();


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
