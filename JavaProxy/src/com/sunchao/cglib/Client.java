package com.sunchao.cglib;

public class Client {
	
	public static void main(String args[]) {
		DyProxyCglib dyProxy = new DyProxyCglib();
		Subject realSubject = new RealSubject();
		Subject proxy = (Subject) dyProxy.getInstance(realSubject);
		proxy.request();
	}

}
