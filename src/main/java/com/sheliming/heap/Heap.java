package com.sheliming.heap;

/**
 * 堆就是个优先级队列而已，或者，堆其实就是一种树
 * 它是完全二叉树
 * <p>
 * 堆中每个节点的关键字都大于（或等于）这个节点的子节点的关键字。这也是堆中每个节点必须满足的条件。
 * 所以堆和二叉搜索树相比，是弱序的。
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
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        this.currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return (currentSize == 0) ? true : false;
    }

    public boolean isFull() {
        return (currentSize == maxSize) ? true : false;
    }

    /**
     * 插入
     *
     * @param key
     * @return
     */
    public boolean insert(int key) {
        if (isFull()) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    //向上调整
    private void trickleUp(int index) {
        int parent = (index - 1) / 2; //父节点的索引
        Node bottom = heapArray[index]; //将新加的尾节点存在bottom中
        while (index > 0 && heapArray[parent].getData() < bottom.getData()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    /**
     * 删除堆顶元素
     *
     * @return 返回删除的元素
     */
    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    private void trickleDown(int index) {
        Node top = heapArray[index];

        int largeChildIndex;
        while (index < currentSize / 2) { //当前节点至少有一个孩子节点
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = leftChildIndex + 1;

            //
            if (rightChildIndex < currentSize && heapArray[rightChildIndex].getData() > heapArray[leftChildIndex].getData()) {
                largeChildIndex = rightChildIndex;
            } else {
                largeChildIndex = leftChildIndex;
            }

            if (top.getData() >= heapArray[largeChildIndex].getData()) {
                break;
            }

            heapArray[index] = heapArray[largeChildIndex];
            index = largeChildIndex;
        }
        heapArray[index] = top;
    }

    public void display() {
        System.out.print("Heap:");
        for (int i = 0; i < currentSize; i++) {
            if (heapArray[i] != null) {
                System.out.print(heapArray[i].getData() + "");
            } else {
                System.out.print("--");
            }
        }
        System.out.println();
    }


    class Node {
        private int data;

        public Node(int data) {
            this.data = data;
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        Heap heap = new Heap(100);
        heap.insert(3);
        heap.insert(6);
        heap.insert(9);
        heap.insert(6);
        heap.insert(3);
        heap.insert(5);
        heap.insert(7);
        heap.insert(1);
        heap.insert(2);

        heap.display();

        System.out.println(heap.remove().getData());
        System.out.println(heap.remove().getData());
        System.out.println(heap.remove().getData());
        System.out.println(heap.remove().getData());
        System.out.println(heap.remove().getData());
        System.out.println(heap.remove().getData());
        System.out.println(heap.remove().getData());
        System.out.println(heap.remove().getData());
        System.out.println(heap.remove().getData());


    }
}
