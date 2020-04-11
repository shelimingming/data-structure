package com.tengxun.tree;

public class L07_重建二叉树 {

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

        return buildTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int preBegin, int preEnd, int[] inorder, int inBegin, int inEnd) {
        TreeNode root = new TreeNode(preorder[preBegin]);

        int curr = inBegin;
        while(inorder[curr]!=preorder[preBegin]) {
            curr++;
        }

        int leftNum = curr-inBegin;
        int rightNum = inEnd -curr;

        if(leftNum>0) {
            root.left = buildTree(preorder,preBegin+1,preBegin+leftNum-1,inorder,inBegin,curr-1);
        }
        if(rightNum>0) {
            root.right = buildTree(preorder,preBegin+leftNum+1,preEnd,inorder,curr+1,inEnd);
        }

        return root;
    }

}
