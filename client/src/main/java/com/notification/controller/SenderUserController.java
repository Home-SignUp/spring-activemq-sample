package com.notification.controller;

import javax.validation.Valid;

import com.notification.message.MessageReceiver;
import com.notification.message.MessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.notification.model.User;
import com.notification.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * @see http://www.useof.org/java/org.springframework.jms.core.JmsTemplate
 */

@Controller
public class SenderUserController {

    private static final Logger logger = LoggerFactory.getLogger(SenderUserController.class);

	@Autowired
    UserService userService;

    @Autowired
    private MessageReceiver messageReceiver;

    @Autowired
    JmsTemplate jmsTemplate;


	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String prepareProduct(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = { "/newNotification" }, method = RequestMethod.GET)
	public String prepareUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "create";
	}

	@RequestMapping(value = { "/newNotification" }, method = RequestMethod.POST)
	public String sendUser(@Valid User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "create";
		}
		userService.sendUser(user);
		model.addAttribute("success", "Уведомление для получателя № " + user.getPublicId() + " отправлено");
		return "sendNotification";
	}
	
	@RequestMapping(value = { "/checkStatus" }, method = RequestMethod.GET)
	public String checkUserStatus(ModelMap model) {
        model.addAttribute("users", messageReceiver.getUsers()); //model.addAttribute("users", userService.getAllUsers());

        ////////////////////////////////////////////////
        System.err.println("////////////////////////////////////////////////");
        System.err.println("jmsTemplate.getPriority() .... " + jmsTemplate.getPriority());
        System.err.println("jmsTemplate.getDeliveryDelay() .... " + jmsTemplate.getDeliveryDelay());
        System.err.println("jmsTemplate.getMessageConverter() .... " + jmsTemplate.getMessageConverter().toString());
        System.err.println("jmsTemplate.isMessageTimestampEnabled() .... " + jmsTemplate.isMessageTimestampEnabled());
        System.err.println("jmsTemplate.isPubSubNoLocal() .... " + jmsTemplate.isPubSubNoLocal());
        System.err.println("jmsTemplate.isPubSubDomain() .... " + jmsTemplate.isPubSubDomain());
        System.err.println("jmsTemplate.getDestinationResolver() .... " + jmsTemplate.getDestinationResolver());
        System.err.println("////////////////////////////////////////////////");
        ////////////////////////////////////////////////
		return "confirmNotification";
	}
}
