package com.github.ralgond.de.sbconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.ralgond.de.sdk.GreetingService;

@Service
public class HelloWorldImpl implements HelloWorld {

	//@Reference(group="dubbo", version="0.0.1", check=false)
	@Autowired
	GreetingService greetingService;
	
	@Override
	public String sayHello(String name) {
		return "hello "+name +" "+greetingService.sayHello(name);
	}

}
