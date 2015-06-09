package com.sunchao.proxy;

public class RealSubject implements Subject {

	@Override
	public void singer() {
		System.out.println("I'm singing, is that good?");
	}

}
