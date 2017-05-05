package com.notification.message;

import javax.jms.JMSException;

import com.notification.dao.UserRepository;
import com.notification.model.NotificationStatus;
import com.notification.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.stereotype.Component;

import com.notification.model.InventoryResponse;
import com.notification.service.UserService;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageReceiver {

//    static final Logger                     LOG = LoggerFactory.getLogger(MessageReceiver.class);
    private static final String USER_SEND_QUEUE = "sender"; //TODO Очередь уже подтвержденных клиентских заказов
	
	@Autowired
    UserService userService;

    @Autowired
    UserRepository userRepository;

    Map<String, User> users = new HashMap<String, User>();

    /*
     * 'receive' == он же метод 'onMessage()'...
     * *****************************************
     * 'onMessage()' - это дефолтный метод он слушает-получает (обрабатывает) все сообщения которые адресуемые этому клиенту
     */
	@JmsListener(destination = USER_SEND_QUEUE) //TODO: каждый юзер является уникальным, поэтому под каждого юзера можно создавать уникальную очередь (по ID)
	public void receiveMessage(final Message<InventoryResponse> message) throws JMSException {
//        LOG.debug("Получает отправитель после отправки уведомления <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.err.println("Получает отправитель после отправки уведомления <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
		MessageHeaders headers =  message.getHeaders();
//		LOG.debug("Отправитель ПОЛУЧЕННЫЙ 'HEADERS': {}", headers);
        System.err.println("Отправитель ПОЛУЧЕННЫЙ 'HEADERS': " + headers);
		
		InventoryResponse response = message.getPayload();
        //////////////////////////////
        User user = userRepository.getUser(response.getUserId());
        if(response.getReturnCode()==200) {
            user.setStatus(NotificationStatus.CONFIRMED);
        } else if(response.getReturnCode()==300) {
            user.setStatus(NotificationStatus.FAILED);
        } else {
            user.setStatus(NotificationStatus.PENDING);
        }
        users.put(user.getId(), user);
        //////////////////////////////
//		LOG.debug("Отправитель ПОЛУЧЕННЫЙ 'RESPONSE': {}", response); //TODO: проверить чтобы ID-сообщения принадлежала этому юзеру и только тогда его принимать - уведомлять о том что оно доставлено..
        System.err.println("Отправитель ПОЛУЧЕННЫЙ 'RESPONSE': " + response);
		
		userService.updateUser(response);
//        LOG.debug("Получает отправитель после отправки уведомления <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        System.err.println("Получает отправитель после отправки уведомления <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
	}

    public Map<String, User> getUsers() {
        return users;
    }
}
