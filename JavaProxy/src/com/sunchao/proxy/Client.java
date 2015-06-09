package com.sunchao.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
	
	public static void main(String args[]) {
		Subject real = new RealSubject();
		InvocationHandler dyProxy = new DyProxy(real);
		Subject proxy = (Subject) Proxy.newProxyInstance(real.getClass().getClassLoader(),
				real.getClass().getInterfaces(), dyProxy);
		proxy.singer();
	}

}
