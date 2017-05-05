package com.notification.service;

import java.util.HashMap;
import java.util.Map;

import com.notification.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notification.message.MessageSender;
import com.notification.model.InventoryResponse;
import com.notification.model.User;
import com.notification.model.NotificationStatus;
import com.notification.util.BasicUtil;

@Service("userService")
public class UserServiceImpl implements UserService {

	static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	MessageSender messageSender;
	
	@Autowired
    UserRepository userRepository;

    Map<String, User> users = new HashMap<String, User>();
	
	@Override
	public void sendUser(User user) {
        LOG.debug("Клиентский сервис в момент отправки уведомления |||||||||||||||||||||||||||||||||||||||||||||||||||||");
		user.setId(BasicUtil.getUniqueId());
		user.setStatus(NotificationStatus.CREATED);
		userRepository.putUser(user); //TODO: updateUser(user)
		LOG.debug("Application : sending notification request {}", user);
		messageSender.sendMessage(user);
        //////////////////////////////
        users.put(user.getId(), user);
        //////////////////////////////
        LOG.debug("Клиентский сервис в момент отправки уведомления |||||||||||||||||||||||||||||||||||||||||||||||||||||");
	}

    /**
     * На сервере сообщений хранится идентификатор заказа.
     * ***************************************************
     * Но сам объект-заказа хранится в (постоянном хранилище) базе данных.
     * И когда от сервера сообщений приходит подтверждение - по идентификатору заказа ищем этот этот заказ и достаем этот объект...
     * (но Spring умеет эммитировать только временный репозиторий базы данных...)
     */
	@Override
	public void updateUser(InventoryResponse response) {
////        System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
////        System.err.println( response );
////        System.err.println("-------------------------------------------------------");
////        System.err.println( response.getOrderId() );
////        System.err.println("-------------------------------------------------------");
////        System.err.println( orderRepository.getOrder(response.getOrderId()) );
////        System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
//
//		User user = userRepository.getUser(response.getUserId());
//
//		if(response.getReturnCode()==200) {
//			user.setStatus(NotificationStatus.CONFIRMED);
//		} else if(response.getReturnCode()==300) {
//			user.setStatus(NotificationStatus.FAILED);
//		} else {
//			user.setStatus(NotificationStatus.PENDING);
//		}
//        userRepository.updateUser(user);
	}

    @Override
	public Map<String, User> getAllUsers(){
		return userRepository.getAllUsers();
	}

    public Map<String, User> getUsers() {
        return users;
    }

}
