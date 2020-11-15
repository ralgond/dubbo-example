package com.github.ralgond.de.consumer;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.github.ralgond.de.sdk.GreetingService;

public class ApiSleepConsumerTwoThreads {

	public static class ConsumerThread extends Thread {
		GreetingService service;
		public ConsumerThread(GreetingService service, int id) {
			super(""+id);
			this.service = service;
			
		}
		public void run() {
			long begin = System.currentTimeMillis();
			System.out.println("["+this.getName()+"] begin:"+begin+" ");
			service.sleepMs(3000);
			long end = System.currentTimeMillis();
			System.out.println("["+this.getName()+"] end  :"+end+ " eclapsed: "+(end - begin)+"ms");
		}
	}
	
	public static void main(String args[]) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("consumer.xml");
		context.start();
		
		GreetingService service = (GreetingService)context.getBean("greetingService");
		
		ConsumerThread t1 = new ConsumerThread(service, 1);
		ConsumerThread t2 = new ConsumerThread(service, 2);
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
