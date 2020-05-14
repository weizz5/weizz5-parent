package com.weizz5.designPatterns.strategy;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/05/14
 */
public class StringChecker implements Checker{


    @Override
    public boolean check(String str) {

        try {
            int value = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}
