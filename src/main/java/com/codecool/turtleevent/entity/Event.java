package com.codecool.turtleevent.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Entity
public class Event {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private Date fromDate;
    private Date toDate;
    @OneToMany
    private List<UserRole> participants;
    private List<StuffToBring> stuffsToBring;
    private List<StuffToDo> stuffsToDo;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
select *
from events
left join events_users_roles
    on event.id = events_users_roles.event_id
left join users
    on events_users_roles.user_id = users.id
left join roles
    on events_users_roles.role_id = roles.id