package com.sheliming.leetcode.offer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 * <p>
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 * <p>
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 * <p>
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,2,2,3,4,4,3]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：root = [1,2,2,null,3,null,3]
 * 输出：false
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 1000
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/dui-cheng-de-er-cha-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L28_对称的二叉树 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode t1,TreeNode t2) {
        if(t1==null&&t2==null) {
            return true;
        }
        if(t1==null||t2==null) {
            return false;
        }
        if(t1.val!=t2.val) {
            return false;
        }
        return isSymmetric(t1.left,t2.right)&&isSymmetric(t1.right,t2.left);
    }
}
