package com.github.ralgond.de.sdk;

public interface GreetingService {
	String sayHello(String name);
	
	String sleepMs(long ms);
	
	String throwRuntimeException();
}
