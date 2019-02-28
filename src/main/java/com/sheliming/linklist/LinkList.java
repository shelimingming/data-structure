package com.sheliming.linklist;

//https://www.cnblogs.com/smyhvae/p/4782595.html
public class LinkList {
    public Node head;//指向头结点
    public Node current;//指向最后一个节点

    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //向链表中添加数据
    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            current = node;
        } else {
            current.next = node;
            current = current.next;
        }
    }

    //打印链表
    public void print(Node node) {
        if (node == null) {
            return;
        }

        Node current = node;
        while (current != null) {
            System.out.print(current.data + ",");
            current = current.next;
        }
    }

    //返回链表中节点的个数
    public int getLength() {
        if (head == null) {
            return 0;
        }

        Node current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    //查找单链表中的倒数第k个结点
//    这里需要声明两个指针：
//    即两个结点型的变量first和second，首先让first和second都指向第一个结点，
//    然后让second结点往后挪k-1个位置，此时first和second就间隔了k-1个位置，
//    然后整体向后移动这两个节点，直到second节点走到最后一个结点的时候，
//    此时first节点所指向的位置就是倒数第k个节点的位置。时间复杂度为O（n）
    public Node findListNode(int index) {
        if(head==null||index==0) {
            return null;
        }

        Node first = head;
        Node second = head;


        for(int i=0;i<index-1;i++) {
            second = second.next;
            if(second == null) {
                //说明index的值已经大于链表的长度了
                return null;
            }
        }

        while (second.next!=null) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }
        linkList.print(linkList.head);
    }
}
