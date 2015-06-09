package com.sunchao.javasist;

import java.lang.reflect.Field;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.CtNewConstructor;
import javassist.CtNewMethod;
import javassist.NotFoundException;
import javassist.util.proxy.ProxyFactory;
import javassist.util.proxy.ProxyObject;

public class Client {
	
	public static Subject getInstance1(Subject deletge) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		CtClass clazz = pool.makeClass("com.sunchao.javasist.Subject" + 
		                               "JavasistProxy");
		clazz.addInterface(pool.get("com.sunchao.javasist.Subject"));
		clazz.addConstructor(CtNewConstructor.defaultConstructor(clazz));
		clazz.addField(CtField.make("public  com.sunchao.javasist.Subject  deletge;", 
				clazz));
		clazz.addMethod(CtNewMethod.make("public void request() { deletge.request();}",
				          clazz));
		Class<?> clz = clazz.toClass();
		Subject proxy  = (Subject) clz.newInstance();
		Field field = proxy.getClass().getField("deletge");
		field.set(proxy, deletge);
		return proxy;
	}
	
	public static Subject getInstance(Subject deletge) throws Exception {
		ProxyFactory factory = new ProxyFactory();
		factory.setInterfaces(new Class[]{Subject.class});
		Class<?> clazz = factory.createClass();
		Subject  proxy = (Subject) clazz.newInstance();
		((ProxyObject)proxy).setHandler(new DyProxy(deletge));
		return proxy;
	}
	
	public static void main(String args[]) throws Exception{
		Subject realSubject = new RealSubject();
		/*Subject proxy = getInstance(realSubject);
		proxy.request();*/
		Subject proxy = getInstance1(realSubject);
		proxy.request();
	}

}
