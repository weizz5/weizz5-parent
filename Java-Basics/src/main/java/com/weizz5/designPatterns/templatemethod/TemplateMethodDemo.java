package com.weizz5.designPatterns.templatemethod;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/14
 */
public class TemplateMethodDemo {

    public static void main(String[] args) {
        AbstractTemplate template1  = new TemplateImpl1();

        template1.operation();


        AbstractTemplate template2  = new TemplateImpl2();

        template1.operation();
    }
}
