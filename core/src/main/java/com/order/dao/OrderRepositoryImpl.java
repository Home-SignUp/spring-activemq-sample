package com.order.dao;

import com.order.model.Order;
import com.order.model.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @see http://www.dineshonjava.com/2012/12/using-namedparameterjdbctemplate-in.html
 */

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private static final String FIND_BY_ID_QUERY = "SELECT * FROM orders WHERE orderId=:orderId",
            FIND_ALL_QUERY = "SELECT * FROM orders",
            INSERT_QUERY = "INSERT INTO orders (orderId,productName,quantity,status) VALUES (:orderId,:productName,:quantity,:status)",
            UPDATE_QUERY = "UPDATE orders SET productName=:productName,quantity=:quantity,status=:status WHERE orderId=:orderId";

    @Autowired
    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

    @Override
    public void putOrder(Order order) {
        Map namedParameters = new HashMap();
        namedParameters.put("orderId", order.getOrderId());
        namedParameters.put("productName", order.getProductName());
        namedParameters.put("quantity", Integer.valueOf(order.getQuantity()));
        namedParameters.put("status", order.getStatus().getName());
        namedParameterJdbcTemplate.update(INSERT_QUERY, namedParameters);
    }

    @Override
    public void updateOrder(Order order) {
        Map namedParameters = new HashMap();
        namedParameters.put("orderId", order.getOrderId());
        namedParameters.put("productName", order.getProductName());
        namedParameters.put("quantity", Integer.valueOf(order.getQuantity()));
        namedParameters.put("status", order.getStatus().getName());
        namedParameterJdbcTemplate.update(UPDATE_QUERY, namedParameters);
    }

    @Override
    public Order getOrder(String orderId) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("orderId", orderId);
        Order result = namedParameterJdbcTemplate.queryForObject(FIND_BY_ID_QUERY, params, new OrderMapper());

        return result;
    }

    @Override
    public Map<String, Order> getAllOrders() {
        Map<String, Order> params = new HashMap<String, Order>();
        List<Order> result = namedParameterJdbcTemplate.query(FIND_ALL_QUERY, params, new OrderMapper());

        Map<String, Order> orders = new HashMap<String, Order>();
        for (Order order : result)
            orders.put(order.getOrderId(), order);

        return orders;
    }

    private static final class OrderMapper implements RowMapper<Order> {
        @Override
        public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
            Order order = new Order();
            order.setOrderId(rs.getString("orderId"));
            order.setProductName(rs.getString("productName"));
            order.setQuantity(rs.getInt("quantity"));
            order.setStatus(OrderStatus.valueOf(rs.getString("status")));

            return order;
        }
    }
}