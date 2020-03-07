package com.sheliming.leetcode.interview.tree;

import java.util.ArrayList;
import java.util.List;

public class L1_二叉搜索树中第K小的元素 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> list = new ArrayList<Integer>();

    /**
     * 中序遍历结果是有序的
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        dfs(root);

        return list.get(k-1);
    }

    public void dfs(TreeNode node) {
        if(node == null) {
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);

        t3.left = t1;
        t3.right = t4;
        t1.right = t2;

        int i = new L1_二叉搜索树中第K小的元素().kthSmallest(t3, 3);
        System.out.println(i);
    }
}
