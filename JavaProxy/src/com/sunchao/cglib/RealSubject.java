package com.sunchao.cglib;

public class RealSubject implements Subject{

	@Override
	public void request() {
		System.out.println("the real subject is doing with the request");
	}

}
