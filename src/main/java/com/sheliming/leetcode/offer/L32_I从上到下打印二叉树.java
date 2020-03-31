package com.sheliming.leetcode.offer;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 *  
 *
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回：
 *
 * [3,9,20,15,7]
 *  
 *
 * 提示：
 *
 * 节点总数 <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L32_I从上到下打印二叉树 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 使用队列层次遍历
     * @param root
     * @return
     */
    public int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[0];
        }

        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left!=null) {
                queue.add(node.left);
            }
            if(node.right!=null) {
                queue.add(node.right);
            }
        }

        int[] result = new int[list.size()];
        for (int i=0;i<list.size();i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
