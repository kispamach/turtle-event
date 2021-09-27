package com.codecool.turtleevent.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Doers")
public class Doer {

    @Id
    private Long id;
    @ManyToOne
    private ToBring toBring;
    @ManyToOne
    private Event event;
    @ManyToOne
    private User user;
    private String attachment;
    private Date createTime;

    public Date getCreate_time() {
        return createTime;
    }

    public void setCreate_time(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }

    public ToBring getToBring() {
        return toBring;
    }

    public void setToBring(ToBring toBring) {
        this.toBring = toBring;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
