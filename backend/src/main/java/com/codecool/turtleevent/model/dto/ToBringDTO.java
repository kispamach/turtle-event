package com.codecool.turtleevent.model.dto;

import com.codecool.turtleevent.model.Bringer;
import com.codecool.turtleevent.model.Event;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

public class ToBringDTO {

    private Long id;
    private long eventId;
    private String title;
    private String comment;
    private int subAmount;
    private Set<Long> bringerIDs;

    public ToBringDTO() {
    }

    public ToBringDTO(long eventId, String title, String comment) {
        this.eventId = eventId;
        this.title = title;
        this.comment = comment;
    }

    public ToBringDTO(Long id, long eventId, String title, String comment, int subAmount, Set<Long> bringerIDs) {
        this.id = id;
        this.eventId = eventId;
        this.title = title;
        this.comment = comment;
        this.subAmount = subAmount;
        this.bringerIDs = bringerIDs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getSubAmount() {
        return subAmount;
    }

    public void setSubAmount(int subAmount) {
        this.subAmount = subAmount;
    }

    public Set<Long> getBringerIDs() {
        return bringerIDs;
    }

    public void setBringers(Set<Long> bringerIDs) {
        this.bringerIDs = bringerIDs;
    }
}
