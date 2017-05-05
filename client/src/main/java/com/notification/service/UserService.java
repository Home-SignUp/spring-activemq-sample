package com.notification.service;

import java.util.Map;

import com.notification.model.InventoryResponse;
import com.notification.model.User;

public interface UserService {
	public void sendUser(User user);
	
	public void updateUser(InventoryResponse response);
	
	public Map<String, User> getAllUsers();

    public Map<String, User> getUsers();
}
