package com.valtech.training.newspringboot.service;

import java.time.LocalDate;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.valtech.training.newspringboot.entity.Order;
import com.valtech.training.newspringboot.repositeries.OrderRepo;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderRepo orderRepo;

	@PostConstruct
	public void populateOrders() {
		orderRepo.save(new Order("mac pro", 24, "for all", LocalDate.of(2023, 9, 9)));
		orderRepo.save(new Order("Apple", 24, "for me", LocalDate.of(2023, 9, 9)));
	}

	@Override
	public Order createOrder(Order order) {
		System.out.println(orderRepo.getClass().getName());
		return orderRepo.save(order);

	}

	@Override
	public Order updateOrder(Order order) {

		return orderRepo.save(order);

	}

//	@Override
//	public Order deleteOrder(Order order) {
//
//		return orderRepo.save(order);
//
//	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public Order getOrder(long orderId) {
		System.out.println(orderRepo.getClass().getName());
		return orderRepo.getReferenceById(orderId);
	}

}
