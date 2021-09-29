package com.codecool.turtleevent.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="bringers")
public class Bringer {

    @Id
    private Long id;
    @ManyToOne
    private ToBring toBrings;
    @ManyToOne
    private Event event;
    @ManyToOne
    private User user;
    private double price;
    private int amount;
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

    public ToBring getToBrings() {
        return toBrings;
    }

    public void setToBrings(ToBring toBrings) {
        this.toBrings = toBrings;
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

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }
}
