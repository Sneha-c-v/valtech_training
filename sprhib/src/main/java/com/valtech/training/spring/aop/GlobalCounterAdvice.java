package com.valtech.training.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

public class GlobalCounterAdvice implements MethodBeforeAdvice {

	public void before(Method method,Object[] args,Object target)	{
		
	}
	
}
