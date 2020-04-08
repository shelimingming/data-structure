package com.tengxun.list;

public class LinkList {
    class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    Node head;
    int size;

    public void addFirst(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;

        size++;
    }

    public void add(int val, int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }

        if (index == 0) {
            addFirst(val);
            return;
        }

        Node node = new Node(val);
        Node preNode = head;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
        node.next = preNode.next;
        preNode.next = node;
        size ++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        if(size == 0) {
            throw new RuntimeException("链表为空");
        }

        //删除头节点
        if(index == 0) {
            head = head.next;
            size--;
            return;
        }

        Node preNode = head;
        for (int i = 0; i < index - 1; i++) {
            preNode = preNode.next;
        }
        preNode.next = preNode.next.next;
        size--;
    }

    public void print() {
        Node curr = head;
        while(curr!=null) {
            System.out.print(curr.val +",");
            curr=curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        linkList.add(1,0);
        linkList.add(2,1);
        linkList.add(3,2);
        linkList.print();

        linkList.add(4,0);
        linkList.print();

        linkList.add(8,2);
        linkList.print();

        linkList.remove(0);
        linkList.print();

        linkList.remove(2);
        linkList.print();

        linkList.remove(2);
        linkList.print();

    }
}
