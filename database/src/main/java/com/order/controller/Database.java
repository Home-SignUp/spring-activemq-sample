package com.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.order.dao.UserDao;
import com.order.model.User;

@Controller
public class Database {

	private static final Logger logger = LoggerFactory.getLogger(Database.class);

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(Model model) {
		logger.debug("order");

		List<User> users = userDao.findAll(); //User user = userDao.findByName("order");
		System.out.println(users);
		model.addAttribute("user", users);

		return "database";
	}
}