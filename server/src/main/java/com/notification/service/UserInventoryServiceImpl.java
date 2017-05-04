package com.notification.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notification.message.MessageSender;
import com.notification.model.InventoryResponse;
import com.notification.model.User;

@Service("orderInventoryService")
public class UserInventoryServiceImpl implements UserInventoryService {

	static final Logger LOG = LoggerFactory.getLogger(UserInventoryServiceImpl.class);
	
	@Autowired
	MessageSender messageSender;
	
	@Override
	public void processUser(User user) {
		/* Perform any business logic. */
		InventoryResponse response = prepareResponse(user);
		LOG.info("Магазин: ПОЛУЧЕНИЯ КЛИЕНТСКОГО ЗАКАЗА ПОДТВЕРЖДЕНО", response);
		messageSender.sendMessage(response);
	}

    /**
     * Эммитация получения ответа от клиента:
     */
	private InventoryResponse prepareResponse(User user) {
		InventoryResponse response = new InventoryResponse();
		response.setUserId(user.getId());
		response.setReturnCode(200);
		response.setComment("Магазин: КЛИЕНТСКИЙ ЗАКАЗ УСПЕШНО ОБРАБОТАН!!!"); //TODO еще сюда можно передать информацию об пользовательском уведомлении
		return response;
	}
}
