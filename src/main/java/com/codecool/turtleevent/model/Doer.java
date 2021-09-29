package com.codecool.turtleevent.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name="doers")
public class Doer {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private ToBring toBring;
    @ManyToOne
    private User user;
    private String attachment;
    private LocalDateTime createTime;

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public ToBring getToBring() {
        return toBring;
    }

    public void setToBring(ToBring toBring) {
        this.toBring = toBring;
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
