package com.weizz5.JUC;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/13
 */
public class Cheese {


    private String name;

    public Cheese(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Cheese{" +
                "name='" + name + '\'' +
                '}';
    }
}
