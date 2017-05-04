package com.notification.message;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.notification.model.User;
import com.notification.service.UserInventoryService;

@Component
public class MessageReceiver {

    static final Logger                        LOG = LoggerFactory.getLogger(MessageReceiver.class);
    private static final String USER_RECEIVE_QUEUE = "receiver"; //TODO Очередь новых клиентских заказов
	
	@Autowired
    UserInventoryService userInventoryService;

    /*
     * 'receive' == он же метод 'onMessage()'...
     * *****************************************
     * 'onMessage()' - это дефолтный метод он слушает-получает (обрабатывает) все сообщения которые адресуемые этому клиенту
     */
	@JmsListener(destination = USER_RECEIVE_QUEUE)
	public void receiveMessage(final Message<User> message) throws JMSException {
        LOG.debug("Получает магазин после отправки заказа >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		MessageHeaders headers =  message.getHeaders();
		LOG.info("Магазин ПОЛУЧЕННЫЙ 'HEADERS': {}", headers);
		
		User user = message.getPayload();
		LOG.info("Магазин ПОЛУЧЕННЫЙ (ORDER): {}", user); //TODO: по ID-юзера вытаскивать сообщения которые ему адрессуются

		userInventoryService.processUser(user);
        LOG.debug("Получает магазин после отправки заказа >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}
