package com.notification.controller;

import com.notification.message.MessageReceiver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReceiverUserController {

//	private static final Logger logger = LoggerFactory.getLogger(ReceiverUserController.class);

    @Autowired
    private MessageReceiver messageReceiver;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String prepareMessage(ModelMap model) {
        model.addAttribute("users", messageReceiver.getUsers());
        return "newNotification";
    }

}
