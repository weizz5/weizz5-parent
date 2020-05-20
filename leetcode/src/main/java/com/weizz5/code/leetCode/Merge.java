package com.weizz5.code.leetCode;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;

/**
 * 56. 合并区间
 * 给出一个区间的集合，请合并所有重叠的区间。
 * <p>
 * 示例 1:
 * 输入: [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 * <p>
 * 示例 2:
 * 输入: [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 *
 * @author weizz5
 * @date 2020/04/16
 */
public class Merge {

    public static void main(String[] args) {

//        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] intervals = new int[][]{{15, 36}, {1, 3}, {9, 13}, {0, 16}, {2, 6}, {8, 10}, {15, 18}};

//        System.out.println(JSON.toJSONString(merge1(intervals)));
        System.out.println(JSON.toJSONString(mergeMyself(intervals)));

    }

    public static int[][] mergeMyself(int[][] intervals) {
//        int[][] result = new int[0][0];

        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);

//        System.out.println(JSON.toJSONString(intervals));

        int index = -1;

        int[][] result = new int[intervals.length][2];

        for (int[] interval : intervals) {

            if (index == -1 || result[index][1] < interval[0]) {
                result[++index] = interval;
            } else {
                result[index][1] = Math.max(result[index][1], interval[1]);
            }
            System.out.println("index:" + index + "," + JSON.toJSONString(result));
        }


        return Arrays.copyOfRange(result, 0, index + 1);
    }


    public static int[][] merge1(int[][] intervals) {
        // 先按照区间起始位置排序
        Arrays.sort(intervals, (v1, v2) -> v1[0] - v2[0]);
        System.out.println(JSON.toJSONString(intervals));
//        Arrays.sort(intervals, (v1, v2) -> v1[1] - v2[1]);
//        System.out.println(JSON.toJSONString(intervals));
//        Arrays.sort(intervals, (v1, v2) -> v2[0] - v1[0]);
//        System.out.println(JSON.toJSONString(intervals));
        // 遍历区间
        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
            // 则不合并，直接将当前区间加入结果数组。
            if (idx == -1 || interval[0] > res[idx][1]) {
                res[++idx] = interval;
            } else {
                // 反之将当前区间合并至结果数组的最后区间
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx + 1);
    }

}
