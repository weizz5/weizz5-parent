package com.weizz5.designPatterns.singleton;

/**
 * 饿汉式
 * 类加载时就创建实例，jvm保证里多线程安全，每个类jvm只会加载一次，静态变量同时也只会加载一次。
 * 唯一缺点：未使用时也会创建对象实例
 *
 * @author weizz5
 * @date 2020/05/12
 */
public class Person1 {

    private static final Person1 person = new Person1("zhangsan");

    private String name;

    private Person1(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Person1 getInstance() {
        return person;
    }


    public static void main(String[] args) {

        Person1 person1 = Person1.getInstance();
        Person1 person2 = Person1.getInstance();

        System.out.println(person1.getName().equals(person2.getName()));

    }
}
