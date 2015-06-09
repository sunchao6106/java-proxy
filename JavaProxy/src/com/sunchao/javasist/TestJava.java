package com.sunchao.javasist;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtConstructor;
import javassist.CtField;
import javassist.CtField.Initializer;
import javassist.CtMethod;
import javassist.CtNewMethod;
import javassist.NotFoundException;

public class TestJava {

	public static void main(String args[]) throws CannotCompileException, NotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		ClassPool cp = ClassPool.getDefault();
		CtClass ctClass = cp.makeClass("com.sunchao.demo.Jvsist");
		StringBuilder body = null;
		CtField ctField = new CtField(cp.get("java.lang.String"), "name", ctClass);
		ctField.setModifiers(Modifier.PRIVATE);
		ctClass.addMethod(CtNewMethod.setter("setName", ctField));
		ctClass.addMethod(CtNewMethod.getter("getName", ctField));
		ctClass.addField(ctField, Initializer.constant("default"));
		CtConstructor ctConstructor  = new CtConstructor(new CtClass[]{}, ctClass);
		body = new StringBuilder();
		body.append("{\n name=\"me\";\n}");
		ctConstructor.setBody(body.toString());
		ctClass.addConstructor(ctConstructor);
		
		CtMethod ctMethod = new CtMethod(CtClass.voidType, "execute", new CtClass[]{},ctClass);
		ctMethod.setModifiers(Modifier.PUBLIC);
		body = new StringBuilder();
		body.append("{\n System.out.println(name);");
		body.append("\n System.out.println(\"execute ok\");");
		body.append("\n return ;");
		body.append("\n }");
		ctMethod.setBody(body.toString());
		ctClass.addMethod(ctMethod);
		Class<?> c = ctClass.toClass();
		Object o = c.newInstance();
		Method method = o.getClass().getMethod("execute", new Class<?>[]{});
		method.invoke(o, new Object[]{});
	}
}
