package com.weizz5.code.leetCode;

/**
 * 矩形重叠
 * <p>
 * 矩形以列表 [x1, y1, x2, y2] 的形式表示，其中 (x1, y1) 为左下角的坐标，(x2, y2) 是右上角的坐标。
 * <p>
 * 如果相交的面积为正，则称两矩形重叠。需要明确的是，只在角或边接触的两个矩形不构成重叠。
 * <p>
 * 给出两个矩形，判断它们是否重叠并返回结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：rec1 = [0,0,2,2], rec2 = [1,1,3,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：rec1 = [0,0,1,1], rec2 = [1,0,2,1]
 * 输出：false
 *
 * @author weizz5
 * @date 2020/03/18
 */
public class IsRectangleOverlap {

    public static void main(String[] args) {

        int[] rec1 = new int[]{0, 0, 2, 2};
        int[] rec2 = new int[]{1, 1, 3, 3};
        isRectangleOverlap(rec1, rec2);
    }

    public static boolean isRectangleOverlap(int[] rec1, int[] rec2) {

        // (x1,y1) (x2,y2) (x1,y2) (x2,y1)
        //
        int rec1xmax = Math.max(rec1[0], rec1[2]);
        int rec1xmin = Math.min(rec1[0], rec1[2]);
        int rec1ymax = Math.max(rec1[1], rec1[3]);
        int rec1ymin = Math.min(rec1[1], rec1[3]);

        int rec2xmax = Math.max(rec2[0], rec2[2]);
        int rec2xmin = Math.min(rec2[0], rec2[2]);
        int rec2ymax = Math.max(rec2[1], rec2[3]);
        int rec2ymin = Math.min(rec2[1], rec2[3]);

        // x、y 轴 两大的最小值大于两小的最大值，则说明存在重叠
        return (Math.min(rec1xmax, rec2xmax) > Math.max(rec1xmin, rec2xmin) &&
                Math.min(rec1ymax, rec2ymax) > Math.max(rec1ymin, rec2ymin));

    }

}
