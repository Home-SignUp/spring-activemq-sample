package com.notification.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.notification.model.User;
import com.notification.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class SenderUserController {

    private static final Logger logger = LoggerFactory.getLogger(SenderUserController.class);

	@Autowired
    UserService userService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String prepareProduct(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = { "/newNotification" }, method = RequestMethod.GET)
	public String prepareUser(ModelMap model) {
		User user = new User();
		model.addAttribute("user", user);
		return "createNotification";
	}

	@RequestMapping(value = { "/newNotification" }, method = RequestMethod.POST)
	public String sendUser(@Valid User user, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "createNotification";
		}
		userService.sendUser(user);
		model.addAttribute("success", "Ваше уведомление для получателя №" + user.getPublicId() + " отправлено");
		return "success";
	}
	
	@RequestMapping(value = { "/checkStatus" }, method = RequestMethod.GET)
	public String checkUserStatus(ModelMap model) {
		model.addAttribute("users", userService.getAllUsers());
		return "notificationStatus";
	}
}
