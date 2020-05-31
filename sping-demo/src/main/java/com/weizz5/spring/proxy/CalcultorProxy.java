package com.weizz5.spring.proxy;

import com.weizz5.spring.service.MyCalculator;
import com.weizz5.spring.util.LogUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/31
 */
public class CalcultorProxy implements InvocationHandler {
    private MyCalculator myCalculator;


    public CalcultorProxy(MyCalculator myCalculator) {
        this.myCalculator = myCalculator;
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        LogUtil.start(method,args);

        Object res = method.invoke(myCalculator,args);
//        LogUtil.stop(method,res );

        return res;
    }
}
