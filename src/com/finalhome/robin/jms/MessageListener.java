package com.finalhome.robin.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;

public class MessageListener implements javax.jms.MessageListener{

	@Override
	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				String textMessage = ((TextMessage) message).getText();
				System.out.println("Message received: " + textMessage);
			} catch (JMSException e) {
				e.printStackTrace();
			}
		}
	}
}
