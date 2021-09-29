package com.codecool.turtleevent.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="to_bring")
public class ToBring {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private Event event;
    private String title;
    private String comment;
    private int subAmount;
    private int totalAmount;
    private Date createTime;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

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

    public int getSubAmount() {
        return subAmount;
    }

    public void setSubAmount(int subAmount) {
        this.subAmount = subAmount;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
