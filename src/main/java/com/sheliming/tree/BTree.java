package com.sheliming.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉（搜索）树
 * 一个节点的左子节点的关键字值小于这个节点，
 * 右子节点的关键字值大于或等于这个节点
 * <p>
 * 部访问的次序可有 V L R 、 L V R 和 L R V 三种选择。
 * 根据节点 V 在其中的访问次序，三种策略也相应地分别称作
 * 先序遍历、中序遍历 和 后序遍历
 * <p>
 * 该节点是叶节点，没有子节点
 * 该节点有一个子节点
 * 该节点有两个子节点:中序后继来代替该节点
 *
 * https://blog.csdn.net/jisuanjiguoba/article/details/80471018
 */
public class BTree<T extends Comparable<T>> {
    private BNode<T> root; //根节点

    public BTree() {
        this.root = null;
    }

    /**
     * 插入数据
     *
     * @param data 待插入的数据
     * @return 插入成功返回插入的节点，插入失败返回null
     */
    public BNode insert(T data) {
        BNode newNode = new BNode(data);
        if (root == null) {
            //还没有根节点，该节点为根节点
            root = newNode;
            return newNode;
        } else {
            //已经存在根节点
            BNode current = root;
            BNode parent = null;
            while (true) {
                parent = current;
                if (((Comparable<T>) newNode.data).compareTo((T) (current.data)) >= 0) {
                    //待插入节点大于等于根节点，向右边循环
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = newNode;
                        newNode.parent = parent;
                        return newNode;
                    }
                } else {
                    //待插入节点小于根节点，向左边循环
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = newNode;
                        newNode.parent = parent;
                        return newNode;
                    }
                }
            }
        }
    }

    /**
     * 前序遍历
     *
     * @return
     */
    public String preOrder() {
        StringBuilder result = new StringBuilder();
        preOrder(result, root);
        return result.toString();
    }

    private void preOrder(StringBuilder result, BNode localRoot) {
        if (localRoot != null) {
            result.append(localRoot.data + " ");
            preOrder(result, localRoot.leftChild);
            preOrder(result, localRoot.rightChild);
        }
        return;
    }

    /**
     * 中序遍历
     *
     * @return
     */
    public String inOrder() {
        StringBuilder result = new StringBuilder();
        inOrder(result, root);
        return result.toString();
    }

    private void inOrder(StringBuilder result, BNode localRoot) {
        if (localRoot != null) {
            inOrder(result, localRoot.leftChild);
            result.append(localRoot.data + " ");
            inOrder(result, localRoot.rightChild);
        }
        return;
    }

    /**
     * 后序遍历
     *
     * @return
     */
    public String postOrder() {
        StringBuilder result = new StringBuilder();
        postOrder(result, root);
        return result.toString();
    }

    private void postOrder(StringBuilder result, BNode localRoot) {
        if (localRoot != null) {
            postOrder(result, localRoot.leftChild);
            postOrder(result, localRoot.rightChild);
            result.append(localRoot.data + " ");
        }
        return;
    }

    public void order() {
        System.out.println("前序遍历:" + preOrder());
        System.out.println("中序遍历:" + inOrder());
        System.out.println("后序遍历:" + postOrder());
    }

    /**
     * 计算二叉树深度：
     * 先遍历二叉树的左子树的深度，然后再遍历二叉树右子树的深度。
     * 最后判断左子树和右子树的深度，如果左子树比右子树深则返回左子树深度+1,
     * 否则返回右子树深度+1。
     *
     * @return 二叉树深度
     */
    public int getTreeDepth() {
        return getTreeDepth(root);
    }

    public int getTreeDepth(BNode bNode) {
        int leftDepth = 0;
        int rightDepth = 0;
        if (bNode == null) {
            return 0;
        }
        if (bNode.leftChild != null) {
            leftDepth = getTreeDepth(bNode.leftChild);
        }
        if (bNode.rightChild != null) {
            rightDepth = getTreeDepth(bNode.rightChild);
        }

        if (leftDepth >= rightDepth) {
            return leftDepth + 1;
        } else {
            return rightDepth + 1;
        }
    }

    /**
     * 返回当前树的节点的个数
     * （1）如果二叉树为空，节点个数为0
     * （2）如果二叉树不为空，二叉树节点个数 = 左子树节点个数 + 右子树节点个数 + 1
     *
     * @return
     */
    public int getNodeNum() {
        return getNodeNum(root);
    }

    private int getNodeNum(BNode node) {
        if (node == null) {
            return 0;
        }
        return getNodeNum(node.leftChild) + getNodeNum(node.rightChild) + 1;
    }

    /**
     * 返回当前树的叶子节点的个数
     * （1）如果二叉树为空，叶子节点个数为0
     * （2）如果节点的左右两个儿子都为空，则该节点为叶子结点
     * （3）二叉树叶子节点个数 = 左子树叶子节点个数 + 右子树叶子节点个数
     *
     * @return
     */
    public int getLevelNodeNum() {
        return getLevelNodeNum(root);
    }

    private int getLevelNodeNum(BNode node) {
        if (node == null) {
            return 0;
        }
        if (node.leftChild == null && node.rightChild == null) {
            return 1;
        }
        return getLevelNodeNum(node.leftChild) + getLevelNodeNum(node.rightChild);
    }

    /**
     * 分层遍历二叉树（按层次从上往下，从左往右）
     * 相当于广度优先搜索，使用队列实现。队列初始化，将根节点压入队列。
     * 当队列不为空，进行如下操作：弹出一个节点，访问，若左子节点或右子节点不为空，将其压入队列。
     *
     * @return
     */
    public String levelTraverse() {
        if (root == null) {
            return null;
        }

        StringBuilder res = new StringBuilder();

        Queue<BNode> queue = new LinkedList<BNode>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            BNode node = queue.poll();
            res.append(node.data + ",");
            if (node.leftChild != null) {
                queue.offer(node.leftChild);
            }
            if (node.rightChild != null) {
                queue.offer(node.rightChild);
            }
        }
        return res.substring(0, res.length() - 1);
    }

    /**
     * 二叉树的节点类
     *
     * @param <T>
     */
    class BNode<T> {
        private T data;
        private BNode parent;
        private BNode leftChild;
        private BNode rightChild;

        public BNode() {
            this.data = null;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        public BNode(T data) {
            if (!(data instanceof Comparable)) {
                throw new RuntimeException("the type of data must implements Comparable!");
            }
            this.data = data;
            this.parent = null;
            this.leftChild = null;
            this.rightChild = null;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            if (!(data instanceof Comparable)) {
                throw new RuntimeException("the type of data must implements Comparable!");
            }
            this.data = data;
        }

        public BNode getParent() {
            return parent;
        }

        public void setParent(BNode parent) {
            this.parent = parent;
        }

        public BNode getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(BNode leftChild) {
            this.leftChild = leftChild;
        }

        public BNode getRightChild() {
            return rightChild;
        }

        public void setRightChild(BNode rightChild) {
            this.rightChild = rightChild;
        }

        public BNode(T data, BNode parent, BNode leftChild, BNode rightChild) {
            this.data = data;
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "BNode{" +
                    "data=" + data +
                    '}';
        }
    }

    /**
     * ***********36
     * *******26         72
     * **************55     80
     * ***********41    60
     * *************43
     *
     * @param args
     */
    public static void main(String[] args) {

        BTree<Integer> tree = new BTree<Integer>();
        tree.insert(36);
        tree.insert(26);
        tree.insert(72);
        tree.insert(55);
        tree.insert(80);
        tree.insert(41);
        tree.insert(60);
        tree.insert(43);

        tree.order();

        System.out.println("树的高度为：" + tree.getTreeDepth());

    }


}
