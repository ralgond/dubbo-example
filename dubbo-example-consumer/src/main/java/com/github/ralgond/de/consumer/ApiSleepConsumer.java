package com.github.ralgond.de.consumer;

import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.ralgond.de.sdk.GreetingService;

public class ApiSleepConsumer {
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		context.start();
		
		GreetingService service = (GreetingService)context.getBean("greetingService");
		
		long begin = System.currentTimeMillis();
		System.out.println(""+begin+" "+service.sleepMs(3000));
		long end = System.currentTimeMillis();
		System.out.println(""+end+ " done sleep: "+(end - begin)+"ms");
	}
}
