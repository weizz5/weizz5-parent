package com.weizz5.code.leetCode;


/**
 * This is Description
 * 二叉树数据结构TreeNode可用来表示单向链表（其中left置空，right为下一个链表节点）。实现一个方法，把二叉搜索树转换为单向链表，要求值的顺序保持不变，
 * 转换操作应是原址的，也就是在原始的二叉搜索树上直接修改。
 * <p>
 * 返回转换后的单向链表的头节点。
 * <p>
 * 示例：
 * 输入： [4,2,5,1,3,null,6,0]
 * 输出： [0,null,1,null,2,null,3,null,4,null,5,null,6]
 * 提示：
 * 节点数量不会超过 100000。
 *
 * @author weizz5
 * @date 2020/04/06
 */
public class ConvertBiNode {


    public static void main(String[] args) {

    }

    public TreeNode convertBiNode(TreeNode root) {
        return convertBiNodeMySelf(root);
    }

    public TreeNode convertBiNodeMySelf(TreeNode root) {


        return root;
    }

    public TreeNode convertBiNode1(TreeNode root) {
        TreeNode head = new TreeNode(0);// 单链表的头指针哨兵
        // 开始中序遍历
        inorder(root, head);
        return head.right;
    }

    private TreeNode inorder(TreeNode root, TreeNode prev) {
        if (root != null) {
            prev = inorder(root.left, prev);
            root.left = null;
            prev.right = root;
            prev = root;
            prev = inorder(root.right, prev);
        }
        return prev;
    }

    class TreeNode {

        TreeNode left;

        TreeNode right;

        int data;

        public TreeNode(int data) {
            this.data = data;
        }
    }

}
