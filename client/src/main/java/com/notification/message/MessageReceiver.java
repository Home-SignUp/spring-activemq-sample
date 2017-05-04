package com.notification.message;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.notification.model.InventoryResponse;
import com.notification.service.UserService;

@Component
public class MessageReceiver {

    static final Logger                     LOG = LoggerFactory.getLogger(MessageReceiver.class);
    private static final String USER_SEND_QUEUE = "sender"; //TODO Очередь уже подтвержденных клиентских заказов
	
	@Autowired
    UserService userService;

    /*
     * 'receive' == он же метод 'onMessage()'...
     * *****************************************
     * 'onMessage()' - это дефолтный метод он слушает-получает (обрабатывает) все сообщения которые адресуемые этому клиенту
     */
	@JmsListener(destination = USER_SEND_QUEUE) //TODO: каждый юзер является уникальным, поэтому под каждого юзера можно создавать уникальную очередь (по ID)
	public void receiveMessage(final Message<InventoryResponse> message) throws JMSException {
        LOG.debug("Получает клиент после оформления заказа <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		MessageHeaders headers =  message.getHeaders();
		LOG.debug("Клиент ПОЛУЧЕННЫЙ 'HEADERS': {}", headers);
		
		InventoryResponse response = message.getPayload();
		LOG.debug("Клиент ПОЛУЧЕННЫЙ 'RESPONSE': {}", response); //TODO: проверить чтобы ID-сообщения принадлежала этому юзеру и только тогда его принимать - уведомлять о том что оно доставлено..
		
		userService.updateUser(response);
        LOG.debug("Получает клиент после оформления заказа <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}
}
