package com.weizz5.code.leetCode;

/**
 * This is Description
 *
 * @author weizz5
 * @date 2020/03/18
 */
public class InnerClass {
    public static void main(String[] args) {

        sort1();

        /**
         * 局部内部类
         */
        class methodClass {
            private void test() {

            }
        }
    }

    /**
     * 匿名内部类
     */
    public static void testInnerClass() {
        InnerClassTest s = new InnerClassTest() {
            public String test() {
                return "";
            }
        };
    }

    /**
     * 静态内部类
     */
    static class StaticInner {

        private static void test() {

        }
    }


    /**
     * 内部类
     */
    class InnerClass1 {

        private void test() {

        }
    }

    /**
     * 直接插入排序
     */
    public static void sort1() {
        int[] array = new int[]{20, 40, 90, 30, 80, 70, 50};
        System.out.println("排序前：");

        for (int m : array) {
            System.out.println(m);
        }

        int temp, j;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            System.out.println("排序，i:" + i + ",temp：" + temp);
            for (j = i - 1; j >= 0 && array[j] > temp; j--) {
                System.out.println("排序,j:" + j + ",1，array[" + j + "]：" + array[j] + ",array[" + (j + 1) + "]：" + array[j + 1]);
                array[j + 1] = array[j];
                System.out.println("排序,j:" + j + ",2，array[" + j + "]：" + array[j] + ",array[" + (j + 1) + "]：" + array[j + 1]);
            }
            array[j + 1] = temp;
            System.out.println("排序，j:" + j + ",array[" + j + "]：" + array[j] + ",array[" + (j + 1) + "]：" + array[j + 1]);
        }
        System.out.println("排序后：");

        for (int m : array) {
            System.out.println(m);
        }
    }
}
