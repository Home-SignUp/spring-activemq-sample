package com.order.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.message.MessageSender;
import com.order.model.InventoryResponse;
import com.order.model.Order;

@Service("orderInventoryService")
public class OrderInventoryServiceImpl implements OrderInventoryService {

	static final Logger LOG = LoggerFactory.getLogger(OrderInventoryServiceImpl.class);
	
	@Autowired
	MessageSender messageSender;
	
	@Override
	public void processOrder(Order order) {
		/* Perform any business logic. */
		InventoryResponse response = prepareResponse(order);
		LOG.info("Приемная : отправка заказа подтверждения {}", response); // Inventory : sending order confirmation
		messageSender.sendMessage(response);
	}

    /**
     * Эммитация получения ответа от клиента:
     * *************************************
     * @param order
     * @return
     */
	private InventoryResponse prepareResponse(Order order) {
		InventoryResponse response = new InventoryResponse();
		response.setOrderId(order.getOrderId());
		response.setReturnCode(200);
		response.setComment("Заказ успешно обработан"); // Order Processed successfully
		return response;
	}
	
}
