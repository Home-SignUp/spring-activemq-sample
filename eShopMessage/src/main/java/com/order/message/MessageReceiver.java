package com.order.message;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.order.model.Order;
import com.order.service.OrderInventoryService;

@Component
public class MessageReceiver {

    static final Logger                     LOG = LoggerFactory.getLogger(MessageReceiver.class);
    private static final String ORDER_NEW_QUEUE = "new-order"; //TODO Очередь новых клиентских заказов
	
	@Autowired
	OrderInventoryService orderInventoryService;

	@JmsListener(destination = ORDER_NEW_QUEUE)
	public void receiveMessage(final Message<Order> message) throws JMSException {
        LOG.debug("Получает магазин после отправки заказа >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		MessageHeaders headers =  message.getHeaders();
		LOG.info("Магазин ПОЛУЧЕННЫЙ 'HEADERS': {}", headers);
		
		Order order = message.getPayload();
		LOG.info("Магазин ПОЛУЧЕННЫЙ (ORDER): {}", order);

		orderInventoryService.processOrder(order);
        LOG.debug("Получает магазин после отправки заказа >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	}
}