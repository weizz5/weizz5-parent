package com.weizz5.code.leetCode;

import java.util.Stack;

/**
 * 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 进阶：
 * 如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
 * <p>
 * 示例：
 * 输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 8 -> 0 -> 7
 *
 * @author weizz5:
 * @date 2020/04/14
 */
public class AddTwoNumbers {

    public static void main(String[] args) {


    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbersMySelf(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (null != l1) {
            stack1.push(l1.val);
            l1 = l1.next;
        }


        while (null != l2) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        /**
         * 进位
         */
        int carry = 0;
        ListNode result = null;

        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;

            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();

            /**
             * 获取当前最新节点
             */
            ListNode node = new ListNode(sum % 10);

            node.next = result;

            result = node;

            carry = sum / 10;

        }

        return result;
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry > 0) {
            int sum = carry;

            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }


}
