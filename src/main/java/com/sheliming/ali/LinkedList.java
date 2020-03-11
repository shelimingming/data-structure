package com.sheliming.ali;

public class LinkedList<E> {
    class Node {
        E val;
        Node next;
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
        if (index > size) {
            return false;
        }
        if (head == null) {
            Node node = new Node();
            node.val = val;
            node.next = null;
            head = node;
            size++;
            return true;
        }
        Node temp = head;
        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }
        Node node = new Node();
        node.val = val;
        node.next = temp.next;
        temp.next = node;

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
        if (index >= size) {
            return false;
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

    public static void main(String[] args) {
        LinkedList<Integer> link = new LinkedList<Integer>();
        link.add(1, 0);
        link.add(2, 1);
        link.add(3, 2);
        link.remove(1);

    }
}
