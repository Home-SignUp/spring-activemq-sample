package com.order.service;

import java.util.Map;

import com.order.model.InventoryResponse;
import com.order.model.Order;

public interface OrderService {
	public void sendOrder(Order order);
	
	public void updateOrder(InventoryResponse response);
	
	public Map<String, Order> getAllOrders();
}
