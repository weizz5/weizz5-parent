package com.weizz5.spring.util;

import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/30
 */

@Aspect
@Component
public class LogUtil {

    @Before(value = "execution(public Integer com.weizz5.spring.service.MyCalculator.add(Integer,Integer ))")
    public static void start(Method method, Object ... objects){
        System.out.println("方法"+ method.getName() +"开始执行，param："+ Arrays.asList(objects));
    }


    @AfterReturning(value = "execution(public Integer com.weizz5.spring.service.MyCalculator.add(Integer,Integer ))")
    public static void stop(Method method,Object ... objects){

        System.out.println("方法"+ method.getName() +"执行结束，result："+ Arrays.asList(objects));
    }

    @AfterThrowing(value = "execution(public Integer com.weizz5.spring.service.MyCalculator.add(Integer,Integer ))")
    public static void logException(Method method,Exception e){

        System.out.println("方法"+ method.getName() +"执行异常："+ e.getMessage());
        e.printStackTrace();
    }


    @After(value = "execution(public Integer com.weizz5.spring.service.MyCalculator.add(Integer,Integer ))")
    public static void logFinally(Method method){

        System.out.println("方法"+ method.getName() +"执行完成。。。。");
    }
}
