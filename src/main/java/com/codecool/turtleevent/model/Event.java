package com.codecool.turtleevent.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @Column(name="from_date")
    private LocalDateTime fromDate;
    @Column(name="to_date")
    private LocalDateTime toDate;
    @Column(name="user_roles")
    @OneToMany
    private List<UserEventRole> userRoles;
    @Column(name="to_bring")
    @OneToMany
    private List<ToBring> toBring;
    @Column(name="to_do")
    @OneToMany
    private List<ToDo> toDo;
    @Column(name="create_time", nullable = false)
    private LocalDateTime createTime;

    public Event() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }

    public List<UserEventRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<UserEventRole> userRoles) {
        this.userRoles = userRoles;
    }

    public List<ToBring> getToBring() {
        return toBring;
    }

    public void setToBring(List<ToBring> toBring) {
        this.toBring = toBring;
    }

    public List<ToDo> getToDo() {
        return toDo;
    }

    public void setToDo(List<ToDo> toDo) {
        this.toDo = toDo;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
