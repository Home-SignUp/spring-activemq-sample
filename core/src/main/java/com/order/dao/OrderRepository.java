package com.order.dao;

import com.order.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderRepository {

    void putOrder(Order order);

    void updateOrder(Order order);

    Order getOrder(String orderId);

    Map<String, Order> getAllOrders();

}