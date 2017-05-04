package com.notification.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.notification.model.InventoryResponse;

@Component
public class MessageSender {

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(final InventoryResponse inventoryResponse) { //TODO: 1 - InventoryResponse
                                                                         //TODO: 2 - передавать нужно специальную информацию об сообщения (в качестве юзера создавать его ID-канала)
		jmsTemplate.send(new MessageCreator(){
				@Override
				public Message createMessage(Session session) throws JMSException{
					ObjectMessage objectMessage = session.createObjectMessage(inventoryResponse);
					return objectMessage;
				}
			});
	}

}
