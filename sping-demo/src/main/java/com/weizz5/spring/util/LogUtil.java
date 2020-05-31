package com.weizz5.spring.util;

import com.alibaba.fastjson.JSON;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
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

    @Pointcut(value = "execution(public Integer com.weizz5.spring.service.MyCalculator.add(Integer,Integer ))")
    public static void pointCut(){

    }

    @Before(value = "execution(public Integer com.weizz5.spring.service.MyCalculator.add(Integer,Integer ))")
    public static void start(JoinPoint joinPoint) {
//        System.out.println("方法"+ method.getName() +"开始执行，param："+ Arrays.asList(objects));
        Signature signature = joinPoint.getSignature();
        try {
//            System.out.println("getArgs:" + JSON.toJSONString(joinPoint.getArgs()));
//            System.out.println("getKind:" + JSON.toJSONString(joinPoint.getKind()));
//            System.out.println("getSignature:" + JSON.toJSONString(joinPoint.getSignature()));
//            System.out.println("getSourceLocation:"+JSON.toJSONString(joinPoint.getSourceLocation()));
//            System.out.println("getStaticPart:" + JSON.toJSONString(joinPoint.getStaticPart()));
//            System.out.println("getTarget:" + JSON.toJSONString(joinPoint.getTarget()));
//            System.out.println("getThis:" + JSON.toJSONString(joinPoint.getThis()));
        } catch (Exception e) {
            System.out.println(joinPoint.toString());
            e.printStackTrace();
        }
//        System.out.println("方法开始执行，param：");
        System.out.println("方法" + signature.getName() + "开始执行，param：" + Arrays.asList(joinPoint.getArgs()));
    }


    @AfterReturning(pointcut = "pointCut()",returning = "result")
    public static void stop(JoinPoint joinPoint,Object result) {

        Signature signature = joinPoint.getSignature();
        System.out.println("方法"+ signature.getName() +"执行结束，result："+ result);
//        System.out.println("方法执行结束，result：");
    }

    @AfterThrowing(value = "execution(public Integer com.weizz5.spring.service.MyCalculator.add(Integer,Integer ))")
    public static void logException() {

//        System.out.println("方法"+ method.getName() +"执行异常："+ e.getMessage());
        System.out.println("方法执行异常：");
//        e.printStackTrace();
    }


    @After(value = "execution(public Integer com.weizz5.spring.service.MyCalculator.add(Integer,Integer ))" )
    public static void logFinally() {

//        System.out.println("方法"+ method.getName() +"执行完成。。。。");
        System.out.println("方法执行完成。。。。");
    }


    /**
     * 环绕通知
     */
    @Around(value = "pointCut()")
    public static void around(){


    }
}
