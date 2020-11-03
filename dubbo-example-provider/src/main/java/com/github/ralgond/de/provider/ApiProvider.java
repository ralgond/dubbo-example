package com.github.ralgond.de.provider;

import java.io.IOException;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import com.github.ralgond.de.sdk.GreetingService;

public class ApiProvider {
	public static void main(String args[]) {
		ServiceConfig<GreetingService> serviceConfig = new ServiceConfig<GreetingService>();
		
		serviceConfig.setApplication(new ApplicationConfig("first-dubbo-provider"));
		
		RegistryConfig registryConfig = new RegistryConfig("zookeeper://127.0.0.1:2181");
		
		serviceConfig.setRegistry(registryConfig);
		
		serviceConfig.setInterface(GreetingService.class);
		serviceConfig.setRef(new GreetingServiceImpl());
		
		serviceConfig.setVersion("0.0.1");
		serviceConfig.setGroup("dubbo");
		
		serviceConfig.export();
		
		System.out.println("server is started");
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
