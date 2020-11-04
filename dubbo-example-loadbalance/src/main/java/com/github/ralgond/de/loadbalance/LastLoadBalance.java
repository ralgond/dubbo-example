package com.github.ralgond.de.loadbalance;

import java.util.List;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.cluster.loadbalance.AbstractLoadBalance;

public class LastLoadBalance extends AbstractLoadBalance {

	@Override
	protected <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) {
		System.out.println("FirstLoadBalance, invokers.size="+invokers.size()+", "+invocation.toString());
		Invoker<T> invoker = null;
		if (invokers.size() > 0) {
			invoker = invokers.get(invokers.size()-1);
		}
		return invoker;
	}
}

