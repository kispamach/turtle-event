package com.codecool.turtleevent.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="to_do")
public class ToDo {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Event event;
    private String title;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
