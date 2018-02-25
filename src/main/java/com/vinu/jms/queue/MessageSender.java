package com.vinu.jms.queue;


import javax.jms.Destination;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;

public class MessageSender {
	private JmsTemplate jmsTemplate;
	private Destination destination;
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	public void sendMessage(String message) {
		jmsTemplate.send(destination, (Session session)->{
			return session.createTextMessage(message);
		});
	}

}
