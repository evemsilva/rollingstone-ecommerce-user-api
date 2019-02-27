package com.rollingstone.listeners;

import com.rollingstone.events.UserEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(UserEvent userEvent) {
		log.info("Received User Event : "+ userEvent.getEventType());
		log.info("Received User From User Event :"+ userEvent.getUser().toString());
	}
}
