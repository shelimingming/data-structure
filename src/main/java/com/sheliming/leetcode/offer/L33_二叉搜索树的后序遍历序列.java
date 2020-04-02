package com.sheliming.leetcode.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * <p>
 *  
 * <p>
 * 参考以下这颗二叉搜索树：
 * <p>
 * 5
 * / \
 * 2   6
 * / \
 * 1   3
 * 示例 1：
 * <p>
 * 输入: [1,6,3,2,5]
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: [1,3,2,6,5]
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L33_二叉搜索树的后序遍历序列 {
    public boolean verifyPostorder(int[] postorder) {
        return verifyPostorder(postorder, 0, postorder.length - 1);
    }

    public boolean verifyPostorder(int[] postorder, int begin, int end) {
        if (begin >= end) {
            return true;
        }
        int root = postorder[end];
        int i= begin;
        while(postorder[i]<root) {
            i++;
        }
        for(int j=i;j<=end;j++) {
            if(postorder[j] < root) {
                return false;
            }
        }

        return verifyPostorder(postorder,begin,i-1)&&verifyPostorder(postorder,i,end-1);
    }

    public static void main(String[] args) {
        int[] postorder = {1, 6, 3, 2, 5};
        System.out.println(new L33_二叉搜索树的后序遍历序列().verifyPostorder(postorder));
    }
}
