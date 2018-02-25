package com.vinu.jms.queue;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestJMS {
	static MessageReciever reciever;
	static MessageSender sender;
	static ClassPathXmlApplicationContext context;
	static BrokerService broker;
	
	public static void main(String[] args) throws URISyntaxException, Exception {
		//broker = BrokerFactory.createBroker(new URI("broker:(tcp://localhost:61616)"));
		//broker.start();
		context = new ClassPathXmlApplicationContext("/applicationContext.xml");		
		sender = context.getBean("sender", MessageSender.class);
		reciever = context.getBean("reciever", MessageReciever.class);
		
		try {
			sender.sendMessage("Hi..");
			System.out.println("Consumer receives " + reciever.receiveMessage());
		} finally {
			broker.stop();
			context.close();
		}
	}
}
