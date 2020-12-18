package com.weizz5.leetCode01;

import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 *
 * @author weizz5
 * @date 2020/03/17
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[4];
        nums[0] = 2;
        nums[1] = 7;
        nums[2] = 11;
        nums[3] = 15;

        int target = 9;

        int[] result = twoSumNew(nums, target);
        System.out.println(JSON.toJSONString(result));

    }


    private static int[] twoSumNew(int[] nums, int target){
        if(nums.length<2){
            return new int[0];
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(!indexMap.containsKey(nums[i])){
                indexMap.put(target-nums[i], i);
            }else{
                return new int[]{i,indexMap.get(nums[i])};
            }
        }
        return new int[0];
    }


















    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> indexMap = new HashMap<>();

        int temp;
        for (int i = 0; i < nums.length; i++) {

            temp = target - nums[i];
            if (indexMap.containsKey(temp)) {
                return new int[]{i, indexMap.get(temp)};
            } else {
                indexMap.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("未找到合法的参数值");
    }

    /**
     * 暴力法很简单，遍历每个元素 xx，并查找是否存在一个值与 target - xtarget−x 相等的目标元素
     * 复杂度分析：
     * <p>
     * 时间复杂度：O(n^2)O(n2)
     * 对于每个元素，我们试图通过遍历数组的其余部分来寻找它所对应的目标元素，这将耗费 O(n) 的时间。因此时间复杂度为 O(n^2)O(n2)。
     * 空间复杂度：O(1)。
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == target - nums[i]) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    /**
     * 两遍哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[]{i, map.get(complement)};
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    /**
     * 一遍哈希表
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum3(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] twoSum4(int[] nums, int target) {
        int Volume = 2048;          //100000000000
        int bitMode = Volume - 1;     //011111111111
        int[] t = new int[Volume];  //store index+1, in order to skip default 0
        for (int i = 0; i < nums.length; i++) {
            int c = (target - nums[i]) & bitMode;
            if (t[c] != 0)
                return new int[]{t[c] - 1, i};
            t[nums[i] & bitMode] = i + 1;
        }
        return null;
    }

}
