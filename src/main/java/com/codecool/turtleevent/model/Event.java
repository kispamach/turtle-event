package com.codecool.turtleevent.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="events")
public class Event {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Date fromDate;
    private Date toDate;
    @OneToMany
    private List<UserRole> userRoles;
    @OneToMany
    private List<ToBring> stuffsToBring;
    @OneToMany
    private List<ToDo> stuffsToDo;
    private LocalDateTime createTime;



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

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public List<ToBring> getStuffsToBring() {
        return stuffsToBring;
    }

    public void setStuffsToBring(List<ToBring> stuffsToBring) {
        this.stuffsToBring = stuffsToBring;
    }

    public List<ToDo> getStuffsToDo() {
        return stuffsToDo;
    }

    public void setStuffsToDo(List<ToDo> stuffsToDo) {
        this.stuffsToDo = stuffsToDo;
    }

    public LocalDateTime getCreate_time() {
        return createTime;
    }

    public void setCreate_time(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
