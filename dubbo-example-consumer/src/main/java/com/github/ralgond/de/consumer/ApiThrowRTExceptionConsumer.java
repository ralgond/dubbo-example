package com.github.ralgond.de.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.ralgond.de.sdk.GreetingService;

public class ApiThrowRTExceptionConsumer {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		context.start();
		
		GreetingService service = (GreetingService)context.getBean("greetingService");
		
		System.out.println(service.throwRuntimeException());
	}
}
