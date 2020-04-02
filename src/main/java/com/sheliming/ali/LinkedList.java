package com.sheliming.ali;

/**
 * 单项链表
 *
 * @param <E>
 */
public class LinkedList<E> {
    class Node {
        E val;
        Node next;

        Node(E val) {
            this.val = val;
        }
    }

    private int size = 0;
    private Node head;

    /**
     * 插入节点
     *
     * @param val
     * @param index
     * @return 成功返回true；失败返回false；
     */
    public boolean add(E val, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        //插入在链表首单独处理
        if (index == 0) {
            Node node = new Node(val);
            node.next = head;
            head = node;
            size++;
            return true;
        }

        //循环找到curr为带插入节点的前面一个节点
        Node curr = head;
        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }
        Node node = new Node(val);
        node.next = curr.next;
        curr.next = node;
        size++;
        return true;
    }

    /**
     * 删除节点
     *
     * @param index 删除的节点，从0开始
     * @return
     */
    public boolean remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            head = head.next;
            size--;
        }
        //要删除节点的上个节点
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        return true;
    }

    public void print() {
        Node node = head;
        while (node != null) {
            System.out.print(node.val + ",");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        LinkedList<Integer> link = new LinkedList<Integer>();
        link.add(1, 0);
        link.add(2, 1);
        link.add(3, 2);
        link.add(8, 0);
        link.add(8, 4);
        link.print();
        link.remove(1);
        link.print();

    }
}
