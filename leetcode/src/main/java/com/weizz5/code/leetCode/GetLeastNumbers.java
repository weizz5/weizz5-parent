package com.weizz5.code.leetCode;

import com.alibaba.fastjson.JSON;

import java.util.*;

/**
 * TOPK
 * <p>
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 *
 * @author weizz5
 * @date 2020/03/20
 */
public class GetLeastNumbers {

    public static void main(String[] args) {

//        int[] arr = new int[]{3,1, 2, 1,5,};
        int[] arr = new int[]{10002, 10003, 10006, 10009, 10007,};

        long time = System.currentTimeMillis();
        int[] result = getLeastNumbersPersonal2(arr, 4);
        System.out.println("getLeastNumbersPersonal result:" + JSON.toJSONString(result) + ",耗时:" + (System.currentTimeMillis() - time) + " ms");
        time = System.currentTimeMillis();

        int[] arr1 = new int[]{3, 2, 1, 5,};
        int[] result1 = getLeastNumbers1(arr1, 2);
        System.out.println("getLeastNumbers1 result:" + JSON.toJSONString(result1) + ",耗时:" + (System.currentTimeMillis() - time) + " ms");
        time = System.currentTimeMillis();

        int[] arr2 = new int[]{3, 1, 2, 1, 5,};
        int[] result2 = getLeastNumbers2(arr2, 2);
        System.out.println("getLeastNumbers2 result:" + JSON.toJSONString(result2) + ",耗时:" + (System.currentTimeMillis() - time) + " ms");
        time = System.currentTimeMillis();

//        int[] arr3 = new int[]{3,1, 2, 1,5,};
        int[] arr3 = new int[]{10002, 10003, 10006, 10009, 10007,};
        int[] result3 = getLeastNumbers3(arr3, 2);
        System.out.println("getLeastNumbers3 result:" + JSON.toJSONString(result3) + ",耗时:" + (System.currentTimeMillis() - time) + " ms");
        time = System.currentTimeMillis();

        int[] arr4 = new int[]{3, 1, 2, 1, 5,};
        int[] result4 = getLeastNumbers4(arr4, 3);
        System.out.println("getLeastNumbers4 result:" + JSON.toJSONString(result4) + ",耗时:" + (System.currentTimeMillis() - time) + " ms");

    }

    /**
     * 用快排最最最高效解决TopK问题：O(N)
     * 快排切分时间复杂度分析：
     * 因为我们是要找下标为k的元素，第一次切分的时候需要遍历整个数组(0 ~ n)找到了下标是j的元素，假如k比j小的话，
     * 那么我们下次切分只要遍历数组(0~k-1)的元素就行啦，反之如果k比j大的话，那下次切分只要遍历数组(k+1～n)的元素就行啦，
     * 总之可以看作每次调用partition遍历的元素数目都是上一次遍历的1/2，因此时间复杂度是N + N/2 + N/4 + ... + N/N = 2N, 因此时间复杂度是O(N)。
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers1(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    private static int[] quickSearch(int[] nums, int lo, int hi, int k) {
        // 每快排切分1次，找到排序后下标为j的元素，如果j恰好等于k就返回j以及j左边所有的数；
        int j = partition(nums, lo, hi);
        if (j == k) {
            return Arrays.copyOf(nums, j + 1);
        }
        // 否则根据下标j与k的大小关系来决定继续切分左段还是右段。
        return j > k ? quickSearch(nums, lo, j - 1, k) : quickSearch(nums, j + 1, hi, k);
    }

    // 快排切分，返回下标j，使得比nums[j]小的数都在j的左边，比nums[j]大的数都在j的右边。
    private static int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo, j = hi + 1;
        while (true) {
            while (++i <= hi && nums[i] < v) ;
            while (--j >= lo && nums[j] > v) ;
            if (i >= j) {
                break;
            }
            int t = nums[j];
            nums[j] = nums[i];
            nums[i] = t;
        }
        nums[lo] = nums[j];
        nums[j] = v;
        return j;
    }

    /**
     * 大根堆(前K小) / 小根堆（前K大),Java中有现成的PriorityQueue，实现起来最简单：O(NlogK)
     * 本题是求前K小，因此用一个容量为K的大根堆，每次poll出最大的数，那堆中保留的就是前K小啦
     * （注意不是小根堆！小根堆的话需要把全部的元素都入堆，那是O(NlogN)😂，就不是O(NlogK)啦～～）
     * 这个方法比快排慢，但是因为Java中提供了现成的PriorityQueue（默认小根堆）, 所以实现起来最简单，没几行代码～
     * <p>
     * 保持堆的大小为K，然后遍历数组中的数字，遍历的时候做如下判断：
     * 1. 若目前堆的大小小于K，将当前数字放入堆中。
     * 2. 否则判断当前数字与大根堆堆顶元素的大小关系，如果当前数字比大根堆堆顶还大，这个数就直接跳过；
     * 反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((num2, num1) -> num1 - num2);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
//            System.out.println(JSON.toJSONString(pq));
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    /**
     * 二叉搜索树也可以O(NlogK)解决TopK问题哦
     * BST相对于前两种方法没那么常见，但是也很简单，和大根堆的思路差不多～
     * 要提的是，与前两种方法相比，BST有一个好处是求得的前K大的数字是有序的。
     * <p>
     * 因为有重复的数字，所以用的是TreeMap而不是TreeSet（有的语言的标准库自带TreeMultiset，也是可以的）。
     * <p>
     * TreeMap的key是数字，value是该数字的个数。
     * 我们遍历数组中的数字，维护一个数字总个数为K的TreeMap：
     * 1.若目前map中数字个数小于K，则将map中当前数字对应的个数+1；
     * 2.否则，判断当前数字与map中最大的数字的大小关系：若当前数字大于等于map中的最大数字，就直接跳过该数字；若当前数字小于map中的最大数字，则将map中当前数字对应的个数+1，并将map中最大数字对应的个数减1.
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers3(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // TreeMap的key是数字, value是该数字的个数。
        // cnt表示当前map总共存了多少个数字。
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int cnt = 0;
        for (int num : arr) {
            // 1. 遍历数组，若当前map中的数字个数小于k，则map中当前数字对应个数+1
            if (cnt < k) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                cnt++;
                continue;
            }
            // 2. 否则，取出map中最大的Key（即最大的数字), 判断当前数字与map中最大数字的大小关系：
            //    若当前数字比map中最大的数字还大，就直接忽略；
            //    若当前数字比map中最大的数字小，则将当前数字加入map中，并将map中的最大数字的个数-1。
            Map.Entry<Integer, Integer> entry = map.lastEntry();
            if (entry.getKey() > num) {
                map.put(num, map.getOrDefault(num, 0) + 1);
                if (entry.getValue() == 1) {
                    map.pollLastEntry();
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }

        }

        // 最后返回map中的元素
        int[] res = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            while (freq-- > 0) {
                res[idx++] = entry.getKey();
            }
        }
        return res;
    }


    /**
     * 数据范围有限时直接计数排序就行了：O(N)
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers4(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 统计每个数字出现的次数
        int[] counter = new int[10001];
        for (int num : arr) {
            counter[num]++;
        }
        // 根据counter数组从头找出k个数作为返回结果
        int[] res = new int[k];
        int idx = 0;
        for (int num = 0; num < counter.length; num++) {
            while (counter[num]-- > 0 && idx < k) {
                res[idx++] = num;
            }
            if (idx == k) {
                break;
            }
        }
        return res;
    }

    public static int[] getLeastNumbersPersonal(int[] arr, int k) {
        int[] result = new int[k];

        int tmp;
        for (int i = 0; i < arr.length; i++) {
            tmp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (tmp > arr[j]) {
                    arr[i] = arr[j];
                    arr[j] = tmp;
                    tmp = arr[i];
                }
            }
        }
        System.out.println("arr:" + JSON.toJSONString(arr));

        for (int i = 0; i < k; i++) {
            result[i] = arr[i];
        }

        return result;
    }

    public static int[] getLeastNumbersPersonal2(int[] arr, int k) {
        // 排序
        Arrays.sort(arr);
        // 返回前k个数
        return Arrays.copyOfRange(arr, arr.length - k, arr.length);

    }
}
