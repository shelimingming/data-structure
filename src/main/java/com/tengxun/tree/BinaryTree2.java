package com.tengxun.tree;


import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree2 {
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
            System.out.print(root.val);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void postOrder(TreeNode root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.val);
        }
    }

    public void midOrder(TreeNode root) {
        if (root != null) {
            midOrder(root.left);
            System.out.print(root.val);
            midOrder(root.right);
        }
    }

    public void order(TreeNode root) {
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);

        return leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
    }

    public int getNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getNodeNum(root.left) + getNodeNum(root.right) + 1;
    }

    public int getLevelNodeNum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return getLevelNodeNum(root.left) + getLevelNodeNum(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t5.left = t6;

        //cnew BinaryTree2().preOrder(t1);
//        new BinaryTree2().midOrder(t1);
//        new BinaryTree2().postOrder(t1);
//        new BinaryTree2().order(t1);
        System.out.println(new BinaryTree2().getDepth(t1));
        System.out.println(new BinaryTree2().getNodeNum(t1));
        System.out.println(new BinaryTree2().getLevelNodeNum(t1));
    }
}
