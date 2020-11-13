package com.github.ralgond.de.consumer;

import java.io.IOException;

import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.ralgond.de.sdk.GreetingService;

public class ApiConsumer2 {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		context.start();
		
		GreetingService service = (GreetingService)context.getBean("greetingService");
		
		RpcContext.getContext().setAttachment("company", "raglond");
		
		System.out.println(service.sayHello("world"));
		
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
