package com.weizz5.spring.service;

import com.weizz5.spring.util.LogUtil;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/30
 */
@Component
public class MyCalculator implements Calculator{


    @Override
    public Integer add(Integer i, Integer j) throws NoSuchMethodException {
        Method add = MyCalculator.class.getMethod("add", Integer.class, Integer.class);
//        LogUtil.start(add,i,j);
        Integer result = i+j;
//        LogUtil.stop(add, result);
        return result;
    }

    @Override
    public Integer sub(Integer i, Integer j) throws Exception {
        return 0;
    }

    @Override
    public Integer mul(Integer i, Integer j) throws Exception {
        return 0;
    }

    @Override
    public Integer div(Integer i, Integer j) throws Exception {
        return 0;
    }

//    @Override
//    public Integer sub(Integer i, Integer j) throws Exception{
//        Method sub = MyCalculator.class.getMethod("sub", Integer.class, Integer.class);
//        LogUtil.start(i,j);
//        Integer result = i-j;
//        LogUtil.stop(result);
//        return result;
//    }
//
//    @Override
//    public Integer mul(Integer i, Integer j) throws Exception{
//        Method mul = MyCalculator.class.getMethod("mul", Integer.class, Integer.class);
//        LogUtil.start(i,j);
//        Integer result = i*j;
//        LogUtil.stop(result);
//        return result;
//    }
//
//    @Override
//    public Integer div(Integer i, Integer j) throws Exception{
//        Method add = MyCalculator.class.getMethod("add", Integer.class, Integer.class);
//        LogUtil.start(i,j);
//        Integer result = i/j;
//        LogUtil.stop(result);
//        return result;
//    }
}
