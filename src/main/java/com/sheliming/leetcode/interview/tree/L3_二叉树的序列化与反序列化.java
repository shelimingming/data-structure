package com.sheliming.leetcode.interview.tree;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 *
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 *
 * 示例:
 *
 * 你可以将以下二叉树：
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * 序列化为 "[1,2,3,null,null,4,5]"
 * 提示: 这与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 *
 * 说明: 不要使用类的成员 / 全局 / 静态变量来存储状态，你的序列化和反序列化算法应该是无状态的。
 */
public class L3_二叉树的序列化与反序列化 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    /**
     * 使用层次遍历序列化
     * 没有用null站位，不符合题目要求
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize1(TreeNode root) {
        StringBuilder result = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            if(temp.left!=null) {
                queue.add(temp.left);
            }
            if(temp.right!=null) {
                queue.add(temp.right);
            }
            result.append(temp.val);
        }

        return result.toString();
    }

    /**
     * 使用层次遍历序列化
     * @param root
     * @return
     */
    // Encodes a tree to a single string.
    public String serialize2(TreeNode root) {
        StringBuilder result = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();

            if(temp==null) {
                result.append("null,");
                continue;
            }

            queue.add(temp.left);
            queue.add(temp.right);
            result.append(temp.val).append(",");
        }

        return result.toString();
    }

    /**
     * 使用层次遍历反序列化
     * @param data
     * @return
     */
    // Decodes your encoded data to tree.
    public TreeNode deserialize2(String data) {
        String[] split = data.split(",");
        List<String> list = new LinkedList<String>(Arrays.asList(split));

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        queue.add(root);
        list.remove(0);

        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();


            if(!"null".equals(list.get(0))){
                TreeNode left = new TreeNode(Integer.parseInt(list.get(0)));
                node.left = left;
                queue.add(left);
            }
            list.remove(0);

            if(!"null".equals(list.get(0))){
                TreeNode right = new TreeNode(Integer.parseInt(list.get(0)));
                node.right = right;
                queue.add(right);
            }
            list.remove(0);
        }

        return root;

    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        String res = serialize(root, "");

        return res;
    }

    public String serialize(TreeNode root, String s){
        if(root == null) {
            s += "null,";
            return s;
        }
        s = s + root.val + ",";
        s = s + serialize(root.left);
        s = s + serialize(root.right);
        return s;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List list = new LinkedList<String>(Arrays.asList(split));
        return deserialize(list);

    }

    private TreeNode deserialize(List list) {
        if("null".equals(list.get(0))) {
            list.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt((String)list.get(0)));
        list.remove(0);
        node.left = deserialize(list);
        node.right = deserialize(list);
        return node;
    }

    public static void main(String[] args) {
        TreeNode t3 = new TreeNode(3);
        TreeNode t1 = new TreeNode(1);
        TreeNode t4 = new TreeNode(4);
        TreeNode t2 = new TreeNode(2);
        TreeNode t5 = new TreeNode(5);

        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;

        String serialize = new L3_二叉树的序列化与反序列化().serialize2(t1);
        System.out.println(serialize);

        TreeNode deserialize = new L3_二叉树的序列化与反序列化().deserialize2(serialize);
        String serialize2 = new L3_二叉树的序列化与反序列化().serialize2(deserialize);
        System.out.println(serialize2);
    }
}
