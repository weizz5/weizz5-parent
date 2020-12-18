package com.weizz5.designPatterns.singleton;

/**
 * 懒汉式
 *
 * @author weizz5
 * @date 2020/05/12
 */
public class Person2 {

    private static Person2 person;

//    private static final Object lock = new Object();

    private String name;

    public Person2(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Person2 getInstance() {
        if (null == person) {
            synchronized (Person2.class) {
                if (null == person) {
                    person = new Person2("lisi");
                }
            }
        }
        return person;
    }

    public static void main(String[] args) {

        Person1 person1 = Person1.getInstance();
        Person1 person2 = Person1.getInstance();

        System.out.println(person1.getName().equals(person2.getName()));

    }
}
