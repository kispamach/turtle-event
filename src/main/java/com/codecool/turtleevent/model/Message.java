package com.codecool.turtleevent.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="messages")
public class Message {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User author;
    @ManyToOne
    private Event event;
    private String text;
    private Date posted;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getPosted() {
        return posted;
    }

    public void setPosted(Date posted) {
        this.posted = posted;
    }
}
