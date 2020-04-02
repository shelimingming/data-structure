package com.sheliming.leetcode.offer;

/**
 * 给定一棵二叉搜索树，请找出其中第k大的节点。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: root = [3,1,4,null,2], k = 1
 * 3
 * / \
 * 1   4
 * \
 *    2
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: root = [5,3,6,2,4,null,null,1], k = 3
 * 5
 * / \
 * 3   6
 * / \
 * 2   4
 * /
 * 1
 * 输出: 4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L54_二叉搜索树的第k大节点 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private int count = 0;
    private int result = 0;

    public int kthLargest(TreeNode root, int k) {
        if (root == null || k <= 0) {
            throw new RuntimeException("error input");
        }
        count = k;
        preOrder(root);
        return result;
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        preOrder(root.left);
        if (count == 1) {
            result = root.val;
            count--;
            return;
        }
        count--;
        preOrder(root.right);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(3);
        TreeNode t2 = new TreeNode(1);
        TreeNode t3 = new TreeNode(4);
        TreeNode t4 = new TreeNode(2);

        t1.left = t2;
        t1.right = t3;
        t2.right = t4;

        System.out.println(new L54_二叉搜索树的第k大节点().kthLargest(t1, 1));
    }
}
