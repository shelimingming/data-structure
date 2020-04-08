package com.tengxun.tree;

import java.util.Stack;

public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public void preOrder(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + ",");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void preOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            System.out.println(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

        }
    }

    public void preOrder3(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                System.out.println(curr.val);
                stack.push(curr);
                curr = curr.left;
            }

            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                curr = node.right;
            }
        }
    }

    public void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.left);
            System.out.print(root.val + ",");
            midOrder(root.right);
        }
    }

    public void midOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                System.out.println(node.val);
                curr = node.right;
            }

        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {

            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val + ",");
        }
    }

    public void postOrder2(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lastVisit = null;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            if (!stack.isEmpty()) {
                TreeNode treeroot = stack.peek().right;
                //一个根节点被访问的前提是：无右子树或右子树已被访问过
                if (treeroot == null || treeroot == lastVisit) {
                    curr = stack.pop();
                    System.out.println(curr.val);
                    //修改最近被访问的节点
                    lastVisit = curr;
                    curr = null;
                } else {
                    curr = treeroot;
                }
            }
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;

        new BinaryTree().preOrder3(t1);
    }
}
