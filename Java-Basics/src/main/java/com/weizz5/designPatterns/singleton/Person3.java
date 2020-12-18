package com.weizz5.designPatterns.singleton;


/**
 * 枚举单例
 *
 * @author weizz5
 * @date 2020/05/12
 */
public class Person3 {


    private String name;

    private Person3(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    static enum PersonEnum {

        INSTANCE;

        private Person3 person;

        private PersonEnum() {
            person = new Person3("lisi");
        }

        public Person3 getInstance() {
            return person;
        }

    }

    @Override
    public String toString() {
        return "Person3{" +
                "name='" + name + '\'' +
                '}';
    }

    public Person3 getPerson() {
        return PersonEnum.INSTANCE.getInstance();
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(User.getInstance());

        }
    }
}
