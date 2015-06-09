package com.sunchao.javasist;

import java.io.IOException;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.CtNewMethod;

public class DynamicCreateClass {
	
	public static void main(String args[]) throws CannotCompileException, IOException {
		ClassPool pool = ClassPool.getDefault();
		CtClass clazz = pool.makeClass("com.sunchao.Demo");
		CtMethod method = CtNewMethod.make("public void cry(){}", clazz);
		method.insertBefore("System.out.println(\"I'm a programmer,just coding!\");");
		clazz.addMethod(method);
		clazz.writeFile("D://1/");
	}

}
