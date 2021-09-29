package com.codecool.turtleevent.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="friends")
public class Friend {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToMany
    private List<User> friends;
    private Date createTime;

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
