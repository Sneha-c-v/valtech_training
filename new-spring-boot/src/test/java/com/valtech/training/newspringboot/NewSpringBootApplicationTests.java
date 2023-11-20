package com.valtech.training.newspringboot;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//import com.valtech.training.newspringboot.components.EmployeeDAO;
import com.valtech.training.newspringboot.components.HelloWorld;
import com.valtech.training.newspringboot.entity.Order;
import com.valtech.training.newspringboot.service.OrderService;

@SpringBootTest
class NewSpringBootApplicationTests {
	
	@Autowired
	private HelloWorld helloworld;
	
//	@Autowired
//	private EmployeeDAO employeeDAO;
//	
//	@Autowired
//	private OrderService orderService;
	
	
//	@Test
//	void testOrders() {
//		Order o= orderService.createOrder(new Order("mac pro",25,"for the entire team",LocalDate.of(2023,9, 9)));
//				assertNotEquals(0, o.getId());
//				assertTrue(orderService.getAllOrders().size()>0);
//	}
//	
//	@Test
//	void testEmployeeDAO() {
//		assertEquals(7, employeeDAO.count());
//		assertEquals(7, employeeDAO.getAllEmployees().size());
//	}

	@Test
	void contextLoads() {
		assertNotNull(helloworld);
		System.out.println(helloworld.hello());
		assertEquals("Hello Spring Boot", helloworld.hello());
	}

}
