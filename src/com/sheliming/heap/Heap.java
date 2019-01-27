package com.sheliming.heap;

/**
 * 堆就是个优先级队列而已，或者，堆其实就是一种树
 * 它是完全二叉树
 * <p>
 * 向堆中插入数据，
 * 首先将数据项存放到叶节点中（即存到数组的最后一项），
 * 然后从该节点开始，逐级向上调整，直到满足堆中节点关键字的条件为止。
 * <p>
 * 从堆中删除数据与插入不同，
 * 删除时永远删除根节点的数据，
 * 因为根节点的数据最大，删除完后，
 * 将最后一个叶节点移到根的位置，然后从根开始，逐级向下调整，
 * 直到满足堆中节点关键字的条件为止。
 */
public class Heap {
    private  Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return (currentSize == 0)?true:false;
    }

    public boolean isFull() {
        return (currentSize == maxSize)?true:false;
    }

    /**
     * 插入
     * @param key
     * @return
     */
    public boolean insert(int key) {
        if(isFull()) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    //向上调整
    private void trickleUp(int index) {

    }


    class Node {
        private int data;

        public Node (int data){
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }
}
