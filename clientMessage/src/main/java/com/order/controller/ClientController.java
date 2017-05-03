package com.order.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.order.model.Order;
import com.order.service.OrderService;
import org.springframework.ui.Model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class ClientController {

    private static final Logger logger = LoggerFactory.getLogger(ClientController.class);

	@Autowired
	OrderService orderService;

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String prepareProduct(ModelMap model) {
		return "index";
	}

	@RequestMapping(value = { "/newOrder" }, method = RequestMethod.GET)
	public String prepareOrder(ModelMap model) {
		Order order = new Order();
		model.addAttribute("order", order);
		return "createOrder";
	}

	@RequestMapping(value = { "/newOrder" }, method = RequestMethod.POST)
	public String sendOrder(@Valid Order order, BindingResult result, ModelMap model) {
		if (result.hasErrors()) {
			return "createOrder";
		}
		orderService.sendOrder(order);
		model.addAttribute("success", "Ваш заказ " + order.getProductName() + " отправлен");
		return "success";
	}
	
	@RequestMapping(value = { "/checkStatus" }, method = RequestMethod.GET)
	public String checkOrderStatus(ModelMap model) {
		model.addAttribute("orders", orderService.getAllOrders());
		return "orderStatus";
	}

    @RequestMapping(value = "/api-1", method = RequestMethod.GET)
    public String welcome(Model model) {
        logger.debug("order");

        model.addAttribute("orders", orderService.getAllOrders());

        return "orderData";
    }

}
