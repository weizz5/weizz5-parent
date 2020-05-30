package com.weizz5.spring.service; 

import com.weizz5.spring.proxy.CalcultorProxy;
import com.weizz5.spring.util.LogUtil;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/** 
* MyCalculator Tester. 
* 
* @author weizz5
* @since  05/30/2020
* @version 1.0 
*/ 
public class MyCalculatorTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: add(int i, int j) 
* 
*/ 
@Test
public void testAdd() throws Exception { 
//TODO: Test goes here...
    MyCalculator myCalculator = new MyCalculator();
//    System.out.println(myCalculator.add(1,2));

    Calculator o = (Calculator) Proxy.newProxyInstance(MyCalculator.class.getClassLoader(), new Class[]{Calculator.class}, new CalcultorProxy(myCalculator));

    System.out.println(o.add( 3, 4));
} 

/** 
* 
* Method: sub(int i, int j) 
* 
*/ 
@Test
public void testSub() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: mul(int i, int j) 
* 
*/ 
@Test
public void testMul() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: div(int i, int j) 
* 
*/ 
@Test
public void testDiv() throws Exception { 
//TODO: Test goes here... 
} 


} 
