package com.order.service;

import java.util.Map;

import com.order.dao.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.message.MessageSender;
import com.order.model.InventoryResponse;
import com.order.model.Order;
import com.order.model.OrderStatus;
import com.order.util.BasicUtil;

@Service("orderService")
public class OrderServiceImpl implements OrderService{

	static final Logger LOG = LoggerFactory.getLogger(OrderServiceImpl.class);
	
	@Autowired
	MessageSender messageSender;
	
	@Autowired
    OrderRepository orderRepository;
	
	@Override
	public void sendOrder(Order order) {
        LOG.debug("Клиентский сервис в момент отправки заказа |||||||||||||||||||||||||||||||||||||||||||||||||||||");
		order.setOrderId(BasicUtil.getUniqueId());
		order.setStatus(OrderStatus.CREATED);
		orderRepository.putOrder(order);
		LOG.debug("Application : sending order request {}", order);
		messageSender.sendMessage(order);
        LOG.debug("Клиентский сервис в момент отправки заказа |||||||||||||||||||||||||||||||||||||||||||||||||||||");
	}

    /**
     * На сервере сообщений хранится идентификатор заказа.
     * ***************************************************
     * Но сам объект-заказа хранится в (постоянном хранилище) базе данных.
     * И когда от сервера сообщений приходит подтверждение - по идентификатору заказа ищем этот этот заказ и достаем этот объект...
     * (но Spring умеет эммитировать только временный репозиторий базы данных...)
     */
	@Override
	public void updateOrder(InventoryResponse response) {
//        System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//        System.err.println( response );
//        System.err.println("-------------------------------------------------------");
//        System.err.println( response.getOrderId() );
//        System.err.println("-------------------------------------------------------");
//        System.err.println( orderRepository.getOrder(response.getOrderId()) );
//        System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

		Order order = orderRepository.getOrder(response.getOrderId());

		if(response.getReturnCode()==200){
			order.setStatus(OrderStatus.CONFIRMED);
		}else if(response.getReturnCode()==300){
			order.setStatus(OrderStatus.FAILED);
		}else{
			order.setStatus(OrderStatus.PENDING);
		}
		orderRepository.putOrder(order);
	}
	
	public Map<String, Order> getAllOrders(){
		return orderRepository.getAllOrders();
	}

}
