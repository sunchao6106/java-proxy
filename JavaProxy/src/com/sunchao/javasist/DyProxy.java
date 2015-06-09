package com.sunchao.javasist;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class DyProxy implements MethodHandler {
	private Object realSubject;
	
	public DyProxy(Object realSubject) {
		this.realSubject = realSubject;
	}

	
	
	@Override
	public Object invoke(Object arg0, Method arg1, Method arg2, Object[] arg3)
			throws Throwable {
		// TODO Auto-generated method stub
		 arg1.invoke(realSubject, arg3);
		 return null;
	}

}
