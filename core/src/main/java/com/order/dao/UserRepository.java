package com.order.dao;

import com.order.model.User;

import java.util.Map;

public interface UserRepository {

    void putUser(User user);

    void updateUser(User user);

    User getUser(String userId);

    Map<String, User> getAllUsers();

}