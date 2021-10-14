package com.codecool.turtleevent.model.dto;

import com.codecool.turtleevent.model.RoleType;

public class UserEventRoleDTO {

    private long userId;
    private long eventId;
    private RoleType roleType;


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }
}
