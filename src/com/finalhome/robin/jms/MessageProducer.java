package com.finalhome.robin.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MessageProducer {

	private JmsTemplate jmsTemplate;

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}
	
	public void sendMessage(final String textMessage) {
		jmsTemplate.send(new MessageCreator() {
			
			@Override
			public Message createMessage(Session session) throws JMSException {
				TextMessage msg = session.createTextMessage(textMessage);
				return msg;
			}
		});
	}
}
