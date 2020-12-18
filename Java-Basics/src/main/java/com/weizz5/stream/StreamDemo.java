package com.weizz5.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/08/12
 */
public class StreamDemo {

    static void  generateByArray(){

        String[] array = new String[]{"a", "b", "c", "d", "e"};
        Stream.of(array).forEach(System.out::println);
    }

    static void  generateByCollection(){

        List<String> list = Arrays.asList("a", "b", "c", "d", "e");
        list.stream().forEach(System.out::println);

    }

    static void  generateByGenerateMethod(){
        Stream.generate(() -> {
            for (int i = 0; i < 10; i++) {
                return i;
            }
        }).limit(3).forEach(System.out::println);

    }

    static void  generateByIterate(){

    }

    static void  generateByOtherApi(){

    }

    public static void main(String[] args) {
        generateByGenerateMethod();


    }


}
