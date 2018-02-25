package com.vinu.jms.topic;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;

public class MessageReciever {
	private JmsTemplate jmsTemplate;
	private Destination destination;
	
	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	public void setDestination(Destination destination) {
		this.destination = destination;
	}
	
	public String receiveMessage() throws JMSException {
		TextMessage textMessage = (TextMessage) jmsTemplate.receive(destination); 
		return textMessage.getText();
	}
}
