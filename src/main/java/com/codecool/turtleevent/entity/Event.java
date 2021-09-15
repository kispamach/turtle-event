package com.codecool.turtleevent.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Date fromDate;
    private Date toDate;
    @OneToMany
    private List<User> participants;
    private Map<User, Role> roles;
    private List<StuffToBring> stuffsToBring;
    private List<StuffToDo> stuffsToDo;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
