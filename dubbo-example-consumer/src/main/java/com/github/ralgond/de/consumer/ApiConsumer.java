package com.github.ralgond.de.consumer;

import java.io.IOException;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ReferenceConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.rpc.RpcContext;

import com.github.ralgond.de.sdk.GreetingService;

public class ApiConsumer {

	public static void main(String args[]) {
		ReferenceConfig<GreetingService> refConfig = new ReferenceConfig<GreetingService>();
		
		refConfig.setApplication(new ApplicationConfig("first-dubbo-consumer"));
		
		refConfig.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
		
		refConfig.setInterface(GreetingService.class);
		refConfig.setTimeout(5000);
		
		refConfig.setGroup("dubbo");
		refConfig.setVersion("0.0.1");
		
		refConfig.setLoadbalance("lastLoadBalance");
		
		refConfig.setCheck(false);
		
		GreetingService service = refConfig.get();
		
		RpcContext.getContext().setAttachment("company", "raglond");
		
		System.out.println(service.sayHello("world"));
		try {
			System.in.read();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
