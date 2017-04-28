package com.order.controller;

import com.order.dao.UserDao;
import com.order.model.User;
import org.springframework.ui.ModelMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ShopController {

	private static final Logger logger = LoggerFactory.getLogger(ShopController.class);

	@Autowired
	UserDao userDao;

    @RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
    public String prepareProduct(ModelMap model) {
        return "confirmOrder";
    }

    @RequestMapping(value = "/api-2", method = RequestMethod.GET)
    public String viewUsers(Model model) {
        logger.debug("user");

        List<User> users = userDao.findAll(); //User user = userDao.findByName("order");
        System.err.println(users);
        model.addAttribute("user", users);

        return "userData";
    }
}