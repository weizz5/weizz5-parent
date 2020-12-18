package com.weizz5.code.leetCode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * 两个数组的交集
 * <p>
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2]
 * <p>
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [9,4]
 * <p>
 * 说明:
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 *
 * @author weizz5
 * @date 2020/04/06
 */
public class Intersection {

    public static void main(String[] args) {

        Intersection obj = new Intersection();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        System.out.println(JSON.toJSONString(obj.intersection(nums1, nums2)));

        int[] nums3 = {4, 9, 5};
        int[] nums4 = {9, 4, 9, 8, 4};
        System.out.println(JSON.toJSONString(obj.intersection(nums3, nums4)));

    }

    public int[] intersection(int[] nums1, int[] nums2) {

        return intersection2(nums1, nums2);
    }

    /**
     * 双指针
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] res = new int[set.size()];
        int index = 0;
        for (int num : set) {
            res[index++] = num;
        }

        return res;
    }

    /**
     * 二分查找
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums2);
        for (int target : nums1) {
            if (binarySearch(nums2, target) && !set.contains(target)) {
                set.add(target);
            }
        }

        int index = 0;
        int[] res = new int[set.size()];
        for (int num : set) {
            res[index++] = num;
        }
        return res;
    }


    /**
     * 二分查找实现
     *
     * @param nums   数据，有序数组
     * @param target 目标
     * @return
     */
    public boolean binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            System.out.println("left:" + left + ",right:" + right + ",mid:" + mid);
            if (nums[mid] == target) {
                return true;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return false;
    }

    public int[] intersectionMySelf(int[] nums1, int[] nums2) {
        // 判定数组长度，只要有一个长度为0，就返回一个空数组
        if (nums1 == null || nums2 == null || 0 == nums1.length || 0 == nums2.length) {
            return new int[0];
        }
        // 取交集
        // 方法1 暴力
        List<Integer> resList = new ArrayList<>();
        Set<Integer> nums1Set = new HashSet<>();
        Set<Integer> nums2Set = new HashSet<>();
        for (int nums : nums1) {
            nums1Set.add(nums);
        }

        for (int nums : nums2) {
            if (nums1Set.contains(nums)) {
                nums2Set.add(nums);
            }
        }

//        nums1Set.retainAll(nums2Set);

        int[] res = new int[nums2Set.size()];
        int i = 0;
        for (Integer nums : nums2Set) {
            res[i] = nums;
            i++;
        }
        return res;
    }


    public boolean binarySearch2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        int mid;
        Arrays.sort(nums);

        while (left < right) {
            mid = (right - left) / 2 + left;

            if (target == nums[mid]) {
                return true;
            } else if (target < nums[mid]) {
                right = mid + 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
