package com.github.ralgond.de.sbconsumer;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDubbo
@RestController
@SpringBootApplication
public class Main {

	public static void main(String args[]) {
		SpringApplication.run(Main.class, args);
	}
	
	@Autowired
	HelloWorld helloWorld;
	
	@RequestMapping("/index")
    public String index() {
        
        System.out.println("hello world");
        
        return helloWorld.sayHello("ralgond");
    }
}
