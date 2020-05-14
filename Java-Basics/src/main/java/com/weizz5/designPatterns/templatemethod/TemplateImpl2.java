package com.weizz5.designPatterns.templatemethod;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/14
 */
public class TemplateImpl2 extends AbstractTemplate{
    @Override
    void hookMethod1() {
        System.out.println("TemplateImpl2 hookMethod1.....");
    }

    @Override
    void hookMethod2() {
        System.out.println("TemplateImpl2 hookMethod2.....");
    }
}
