package com.order.service;

import java.util.Map;

import com.order.model.InventoryResponse;
import com.order.model.User;

public interface UserService {
	public void sendUser(User user);
	
	public void updateUser(InventoryResponse response);
	
	public Map<String, User> getAllUsers();
}
