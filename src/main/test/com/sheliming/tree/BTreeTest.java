package com.sheliming.tree;

import org.junit.Assert;
import org.junit.Test;

public class BTreeTest {


    public BTree<Integer> createBTree() {
        /**
         * ***********36
         * *******26         72
         * **************55     80
         * ***********41    60
         * *************43
         */
        BTree tree = new BTree();
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
        BTree<Integer> bTree = createBTree();
        int nodeNum = bTree.getNodeNum();
        Assert.assertEquals(8, nodeNum);
    }

    @Test
    public void levelTraverseTest() {
        BTree<Integer> bTree = createBTree();
        String s = bTree.levelTraverse();
        Assert.assertEquals("36,26,72,55,80,41,60,43", s);
    }


}
