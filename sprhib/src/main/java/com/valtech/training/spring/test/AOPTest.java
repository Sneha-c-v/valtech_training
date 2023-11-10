package com.valtech.training.spring.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.valtech.training.spring.Arithmetic;

class AOPTest {

	private ClassPathXmlApplicationContext appCtx;
	@BeforeEach
	void initialize() {
		appCtx = new ClassPathXmlApplicationContext("aop.xml");
	}
	
	@AfterEach
	void closeall() {
		appCtx.close();
	}
	@Test
	void test() {
		Arithmetic arith=(Arithmetic) appCtx.getBean(Arithmetic.class);
		System.out.println(arith.getClass().getName());
//		System.out.println(arith);
		assertEquals(5, arith.add(2, 3));
		assertEquals(0, arith.sub(2, 2));
		try {
			arith.div(5, 0);
			fail("No Exception occured");
		}catch(Exception e) {
		}
		}
		
		
	}


