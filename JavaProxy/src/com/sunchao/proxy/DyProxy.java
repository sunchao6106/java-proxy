package com.sunchao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DyProxy implements InvocationHandler{
	private Object sub;
	
	public DyProxy() {
		
	}
	
	public DyProxy(Object sub) {
		this.sub = sub;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
	     System.out.println("before invoke the real subject");
	     method.invoke(sub, args);
	     System.out.println("after invoke the real subject");
	     return null;
	}

}
