package com.order.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import com.order.model.Order;

@Component
public class MessageSender {

	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(final Order order) {

        /**
         * Доставка сообщений выполняется в рамках сессии.
         * **************************************************************
         * ed110330-aaa2-4294-bcd4-bc0480e00b22 	Order-2 	CONFIRMED
         * eaf0b7c8-5079-4d44-a28c-e59b103ca453 	Order-4 	CREATED
         * **************************************************************
         * Информация о всех доставленных и недоставленных сообщениях вытягивается из сессии...
         */
		jmsTemplate.send(new MessageCreator(){
				@Override
				public Message createMessage(Session session) throws JMSException{
					ObjectMessage objectMessage = session.createObjectMessage(order);
					return objectMessage;
				}
			});
	}

}
