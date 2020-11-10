package com.github.ralgond.de.provider;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApiProvider2 {

	public static void main(String args[]) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("provider.xml");
        context.start();
        System.out.println("server started.");
        System.in.read(); // 按任意键退出
	}
}
