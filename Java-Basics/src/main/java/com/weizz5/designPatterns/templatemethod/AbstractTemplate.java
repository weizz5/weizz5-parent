package com.weizz5.designPatterns.templatemethod;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/14
 */
public abstract class AbstractTemplate {


    public void operation() {

        hookMethod1();

        hookMethod2();

    }


    abstract void hookMethod1();


    abstract void hookMethod2();


}
