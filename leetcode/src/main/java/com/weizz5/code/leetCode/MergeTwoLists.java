package com.weizz5.code.leetCode;

//import org.apache.dubbo.common.utils.Stack;

import java.util.Stack;

/**
 * 合并两个有序链表
 *
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 *
 * 示例：
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/solution/he-bing-liang-ge-you-xu-lian-biao-by-leetcode/
 * @author weizz5
 * @date 2020/04/14
 */
public class MergeTwoLists {

    public class ListNode{
        int val;

        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }


    /**
     *
     * 想法
     *
     * 我们可以如下递归地定义在两个链表里的 merge 操作（忽略边界情况，比如空链表等）：
     *
     * \left\{ \begin{array}{ll} list1[0] + merge(list1[1:], list2) & list1[0] < list2[0] \\ list2[0] + merge(list1, list2[1:]) & otherwise \end{array} \right.
     * {
     * list1[0]+merge(list1[1:],list2)
     * list2[0]+merge(list1,list2[1:])
     * ​
     *
     * list1[0]<list2[0]
     * otherwise
     * ​
     * 也就是说，两个链表头部较小的一个与剩下元素的 merge 操作结果合并。
     *
     * 算法
     * 我们直接将以上递归过程建模，首先考虑边界情况。
     * 特殊的，如果 l1 或者 l2 一开始就是 null ，那么没有任何操作需要合并，所以我们只需要返回非空链表。否则，我们要判断 l1 和 l2 哪一个的头元素更小，然后递归地决定下一个添加到结果里的值。如果两个链表都是空的，那么过程终止，所以递归过程最终一定会终止。
     *
     * 复杂度分析
     *
     * 时间复杂度：O(n + m)O(n+m)。 因为每次调用递归都会去掉 l1 或者 l2 的头元素（直到至少有一个链表为空），函数 mergeTwoList 中只会遍历每个元素一次。所以，时间复杂度与合并后的链表长度为线性关系。
     *
     * 空间复杂度：O(n + m)O(n+m)。调用 mergeTwoLists 退出时 l1 和 l2 中每个元素都一定已经被遍历过了，所以 n + mn+m 个栈帧会消耗 O(n + m)O(n+m) 的空间。
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        else if (l2 == null) {
            return l1;
        }
        else if (l1.val < l2.val) {
            l1.next = mergeTwoLists1(l1.next, l2);
            return l1;
        }
        else {
            l2.next = mergeTwoLists1(l1, l2.next);
            return l2;
        }

    }

    public ListNode mergeTwoListsMySelf(ListNode l1, ListNode l2) {

        if(null == l1){
            return l2;
        }

        if(null == l2){
            return l1;
        }

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (null != l1 ){
            stack1.push(l1.val);
            l1 = l1.next;
        }

        while (null != l2 ){
            stack2.push(l2.val);
            l2 = l2.next;
        }

        ListNode res = null;
        int val = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() ){
            if(stack1.isEmpty()){
                val = stack2.pop();
            }else if(stack2.isEmpty()){
                val = stack1.pop();
            }else{
                val = stack1.peek() > stack2.peek() ? stack1.pop() : stack2.pop();

            }
            ListNode node = new ListNode(val);
            node.next = res;

            res = node;

        }

        return res;
    }

}
