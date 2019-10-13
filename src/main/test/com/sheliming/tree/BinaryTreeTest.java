package com.sheliming.tree;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTest {


    public BinaryTree<Integer> createBTree() {
        /**
         * ***********36
         * *******26         72
         * **************55     80
         * ***********41    60
         * *************43
         */
        BinaryTree tree = new BinaryTree();
        tree.insert(36);
        tree.insert(26);
        tree.insert(72);
        tree.insert(55);
        tree.insert(80);
        tree.insert(41);
        tree.insert(60);
        tree.insert(43);
        return tree;
    }

    @Test
    public void getNodeNumTest() {
        BinaryTree<Integer> binaryTree = createBTree();
        int nodeNum = binaryTree.getNodeNum();
        Assert.assertEquals(8, nodeNum);
    }

    @Test
    public void getLevelNodeNumTest() {
        BinaryTree<Integer> binaryTree = createBTree();
        int nodeNum = binaryTree.getLevelNodeNum();
        Assert.assertEquals(4, nodeNum);
    }

    @Test
    public void levelTraverseTest() {
        BinaryTree<Integer> binaryTree = createBTree();
        String s = binaryTree.levelTraverse();
        Assert.assertEquals("36,26,72,55,80,41,60,43", s);
    }


}
