package com.valtech.training.newspringboot.service;

import java.util.List;

import com.valtech.training.newspringboot.entity.Order;

public interface OrderService {

	Order createOrder(Order order);

	Order updateOrder(Order order);

//	Order deleteOrder(Order order);

	  Order getOrder (long orderId);
	List<Order> getAllOrders();

	

}