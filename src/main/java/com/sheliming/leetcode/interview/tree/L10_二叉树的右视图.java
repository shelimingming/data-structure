package com.sheliming.leetcode.interview.tree;

import java.util.*;

public class L10_二叉树的右视图 {
    public static  class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 使用层次遍历
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        if (root == null) {
            return list;
        }

        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();

        q1.add(root);
        while(!q1.isEmpty() || !q2.isEmpty()) {
            if(!q1.isEmpty()) {
                while(!q1.isEmpty()) {
                    if(q1.size() == 1) {
                        list.add(q1.peek().val);
                    }

                    TreeNode poll = q1.poll();
                    if(poll.left!=null) {
                        q2.add(poll.left);
                    }
                    if(poll.right!=null) {
                        q2.add(poll.right);
                    }
                }
            } else {
                while(!q2.isEmpty()) {
                    if(q2.size() == 1) {
                        list.add(q2.peek().val);
                    }

                    TreeNode poll = q2.poll();
                    if(poll.left!=null) {
                        q1.add(poll.left);
                    }
                    if(poll.right!=null) {
                        q1.add(poll.right);
                    }
                }
            }

        }
        return list;
    }

    /**
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView2(TreeNode root) {
        Map<Integer, Integer> rightmostValueAtDepth = new HashMap<Integer, Integer>();
        int max_depth = -1;

        /* These two stacks are always synchronized, providing an implicit
         * association values with the same offset on each stack. */
        Stack<TreeNode> nodeStack = new Stack<TreeNode>();
        Stack<Integer> depthStack = new Stack<Integer>();
        nodeStack.push(root);
        depthStack.push(0);

        while (!nodeStack.isEmpty()) {
            TreeNode node = nodeStack.pop();
            int depth = depthStack.pop();

            if (node != null) {
                max_depth = Math.max(max_depth, depth);

                /* The first node that we encounter at a particular depth contains
                 * the correct value. */
                if (!rightmostValueAtDepth.containsKey(depth)) {
                    rightmostValueAtDepth.put(depth, node.val);
                }

                nodeStack.push(node.left);
                nodeStack.push(node.right);
                depthStack.push(depth+1);
                depthStack.push(depth+1);
            }
        }

        /* Construct the solution based on the values that we end up with at the
         * end. */
        List<Integer> rightView = new ArrayList<Integer>();
        for (int depth = 0; depth <= max_depth; depth++) {
            rightView.add(rightmostValueAtDepth.get(depth));
        }

        return rightView;
    }


    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;
        node2.right = node5;
        node3.right = node4;

        List<Integer> integers = new L10_二叉树的右视图().rightSideView(node1);
        System.out.println(integers);
    }
}
