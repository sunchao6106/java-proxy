package com.sunchao.cglib;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DyProxyCglib implements MethodInterceptor {
    private Object realSubject;
	
	public Object getInstance(Object realSubject) {
		this.realSubject = realSubject;
		Enhancer enhancer = new Enhancer();
		enhancer.setSuperclass(this.realSubject.getClass());
		enhancer.setCallback(this);
		return enhancer.create();
	}
    
    
    
	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("before invoke the real request");
		arg3.invokeSuper(arg0, arg2);
		System.out.println("after invoke the real request");
		return null;
	}

}
