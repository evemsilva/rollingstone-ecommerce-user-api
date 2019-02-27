package com.rollingstone.events;

import com.rollingstone.spring.model.User;
import org.springframework.context.ApplicationEvent;

public class UserEvent
		extends ApplicationEvent {

    private String eventType;
    private User   user;

    public String getEventType() {
	return eventType;
    }

    public void setEventType(String eventType) {
	this.eventType = eventType;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public UserEvent(Object source, String eventType, User user) {
	super(source);
	this.eventType = eventType;
	this.user = user;
    }

    @Override
    public String toString() {
	return "User Event [eventType=" + eventType + ", user=" + user + "]";
    }

}
