package com.sheliming.tree;

/**
 * 红黑树
 * <p>
 * 树的平衡：对树中的每个节点在它左边的后代数目和在它右边的后代数目应该大致相等
 * <p>
 * 1.每个节点不是红色就是黑色的；
 * 2.根节点总是黑色的；
 * 3.如果节点是红色的，则它的子节点必须是黑色的（反之不一定）；
 * 4.从根节点到叶节点或空子节点的每条路径，必须包含相同数目的黑色节点（即相同的黑色高度）。
 * <p>
 * 在红-黑树中插入的节点都是红色的，这不是偶然的，因为插入一个红色节点比插入一个黑色节点违背红-黑规则的可能性更小。
 * 原因是：插入黑色节点总会改变黑色高度（违背规则4），但是插入红色节点只有一半的机会会违背规则3。
 * 另外违背规则3比违背规则4要更容易修正。
 * <p>
 * 红-黑树主要通过三种方式对平衡进行修正，改变节点颜色、左旋和右旋。
 */
public class RBTree<T extends Comparable<T>> {
    private RBNode<T> root;

    /**
     * 向红黑树中插入数据
     *
     * @param data
     */
    public void insert(T data) {
        RBNode<T> node = new RBNode<T>(RBColor.RED, data, null, null, null);
        if (node != null) {
            insert(node);
        }
    }

    /**
     * 将节点插入到红黑树中，这个过程与二叉搜索树是一样的
     *
     * @param node
     */
    private void insert(RBNode<T> node) {

    }

    /*************对红黑树节点x进行左旋操作 ******************/
    /*
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    private void leftRotate(RBNode<T> x) {
        //1. 将y的左子节点赋给x的右子节点，并将x赋给y左子节点的父节点(y左子节点非空时)
        RBNode<T> y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        //2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;//如果x的父节点为空，则将y设为父节点
        } else {
            if (x == x.parent.left) {//如果x是左子节点
                x.parent.left = y;//则也将y设为左子节点
            } else {
                x.parent.right = y;//否则将y设为右子节点
            }
        }
        //3. 将y的左子节点设为x，将x的父节点设为y
        y.left = x;
        x.parent = y;
    }

    /*************对红黑树节点y进行右旋操作 ******************/
    /*
     * 左旋示意图：对节点y进行右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     */
    private void rightRotate(RBNode<T> y) {
        // 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
        RBNode<T> x = y.left;
        y.left = x.right;
        if (x.right != null) {
            x.right.parent = y;
        }
        // 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
        x.parent = y.parent;
        if (y.parent == null) {
            this.root = x;
        } else {
            if (y == y.parent.right) {
                y.parent.right = x;
            } else {
                y.parent.left = x;
            }
        }
        // 3. 将x的右子节点设为y，将y的父节点设为x
        x.right = y;
        y.parent = x;
    }

    enum RBColor {
        RED, BLACK
    }

    public class RBNode<T extends Comparable<T>> {
        private RBColor color;
        private T data;
        private RBNode<T> left;
        private RBNode<T> right;
        private RBNode<T> parent;

        public RBNode(RBColor color, T data, RBNode<T> left, RBNode<T> right, RBNode<T> parent) {
            this.color = color;
            this.data = data;
            this.left = left;
            this.right = right;
            this.parent = parent;
        }

        @Override
        public String toString() {
            return "RBNode{" +
                    "color=" + color +
                    ", data=" + data +
                    '}';
        }
    }
}
