package com.valtech.training.spring;

import org.springframework.aop.MethodBeforeAdvice;

public class HelloWorld {
	public String hello(String name) {
		return "Hello"+name;
	}

}
