package com.weizz5.designPatterns.strategy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/13
 */
public class StrategyDemo {


    Comparator comparator = new Comparator() {
        @Override
        public int compare(Object o1, Object o2) {

            return 0;
        }
    };

    public static void main(String[] args) {
        NumberChecker numberChecker = new NumberChecker();
        StringChecker stringChecker = new StringChecker();
        String str = "123";

        System.out.println(checkValue(numberChecker,str));
        System.out.println(checkValue(stringChecker,str));



    }

    public static boolean checkValue(Checker checker, String value){
        return checker.check(value);
    }
}
