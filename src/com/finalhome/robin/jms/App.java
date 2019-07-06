package com.finalhome.robin.jms;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

	public static void main(String[] args) {
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		MessageProducer messageProducer = (MessageProducer) ctx.getBean("messageProducer");
		System.out.println("Sending message...");
		for (int i=0;i<=10;i++) {
			messageProducer.sendMessage(String.valueOf(i));
		}
		System.out.println("Message sent...");
		ctx.close();
	}
}
