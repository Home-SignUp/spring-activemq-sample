package com.order.dao;

import java.util.List;

import com.order.model.User;

public interface UserDao {

	User findByName(String name);
	
	List<User> findAll();

}