package com.valtech.training.spring.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class LogReturningAdvice  implements AfterReturningAdvice{

	@Override
	public void afterReturning(Object returnType, Method method, Object[] arg, Object target) throws Throwable {
		System.out.println("Return Value " +returnType);
	}

}
