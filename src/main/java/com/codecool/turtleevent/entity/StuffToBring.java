package com.codecool.turtleevent.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Map;

@Entity
public class StuffToBring {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String comment;
    private double price;
    private int subAmount;
    private int totalAmount;
    private Map<User, Integer> usersAmount;



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Map<User, Integer> getCurrentAmount() {
        return currentAmount;
    }

    public void setCurrentAmount(Map<User, Integer> currentAmount) {
        this.currentAmount = currentAmount;
    }
}
