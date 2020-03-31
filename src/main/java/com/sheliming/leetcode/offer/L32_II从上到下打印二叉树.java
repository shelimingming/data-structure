package com.sheliming.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回其层次遍历结果：
 * <p>
 * [
 * [3],
 * [9,20],
 * [15,7]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L32_II从上到下打印二叉树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int nowLine = 1;
        int nextLine = 0;

        List<Integer> line = new ArrayList<Integer>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            line.add(node.val);
            nowLine--;


            if (node.left != null) {
                queue.add(node.left);
                nextLine++;
            }
            if (node.right != null) {
                queue.add(node.right);
                nextLine++;
            }

            if (nowLine <= 0) {
                nowLine = nextLine;
                nextLine = 0;
                result.add(line);
                line = new ArrayList<Integer>();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(9);
        TreeNode t3 = new TreeNode(20);
        TreeNode t4 = new TreeNode(15);
        TreeNode t5 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        System.out.println(new L32_II从上到下打印二叉树().levelOrder(t1));
    }
}
