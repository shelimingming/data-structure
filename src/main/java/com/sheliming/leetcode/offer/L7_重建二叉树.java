package com.sheliming.leetcode.offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 */
public class L7_重建二叉树 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode root = buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);


        return root;
    }

    private TreeNode buildTree(int[] preorder, int preBeginIndex, int preEndIndex, int[] inorder, int inBeginIndex, int inEndIndex) {
        //前序遍历的第一个节点就是根节点
        TreeNode root = new TreeNode(preorder[preBeginIndex]);

        //在中序遍历中找到根节点
        int i = inBeginIndex;
        while (inorder[i] != preorder[preBeginIndex]) {
            i++;
        }

        int leftNum = i - inBeginIndex;
        int rightNum = inEndIndex - i;

        if (leftNum > 0) {
            root.left = buildTree(preorder, preBeginIndex + 1, preBeginIndex + leftNum, inorder, inBeginIndex, i - 1);
        }
        if (rightNum > 0) {
            root.right = buildTree(preorder, preBeginIndex + leftNum + 1, preEndIndex, inorder, i + 1, inEndIndex);
        }
        return root;
    }


}
