package com.github.ralgond.de.provider;

import org.apache.dubbo.rpc.RpcContext;

import com.github.ralgond.de.sdk.GreetingService;

public class GreetingServiceImpl implements GreetingService {

	@Override
	public String sayHello(String name) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return "Hello "+name+" "+RpcContext.getContext().getAttachment("company");
	}

}
