package com.sheliming.sort;

import java.util.List;

/**
 * 链表的快速排序
 * https://www.cnblogs.com/morethink/p/8452914.html
 * <p>
 * 我们只需要两个指针p1和p2，这两个指针均往next方向移动，
 * 移动的过程中保持p1之前的key都小于选定的key，p1和p2之间的key都大于选定的key，
 * 那么当p2走到末尾时交换p1与key值便完成了一次切分。
 */
public class LinkQuickSort {
    static class ListNode {
        int value;
        ListNode next;
    }

    public static void sort(ListNode listNode) {
        quickSort(listNode, null);
    }

    public static void quickSort(ListNode head, ListNode end) {
        if (head != end) {
            ListNode node = partition(head, end);
            quickSort(head, node);
            quickSort(node.next, end);
        }
    }

    private static ListNode partition(ListNode head, ListNode end) {

        ListNode p1 = head;
        ListNode p2 = head.next;

        //p2走到最后就停
        while (p2 != end) {
            if (p2.value < head.value) {
                p1 = p1.next;

                int temp = p1.value;
                p1.value = p2.value;
                p2.value = temp;
            }
            p2 = p2.next;
        }

        //最后交换head和p1的值
        if (p1 != head) {
            int temp = p1.value;
            p1.value = head.value;
            head.value = temp;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode n7 = new ListNode();
        n7.value = 8;
        n7.next = null;

        ListNode n6 = new ListNode();
        n6.value = 4;
        n6.next = n7;

        ListNode n5 = new ListNode();
        n5.value = 9;
        n5.next = n6;

        ListNode n4 = new ListNode();
        n4.value = 0;
        n4.next = n5;

        ListNode n3 = new ListNode();
        n3.value = 1;
        n3.next = n4;

        ListNode n2 = new ListNode();
        n2.value = 1;
        n2.next = n3;

        ListNode n1 = new ListNode();
        n1.value = 2;
        n1.next = n2;

        ListNode head = new ListNode();
        head.value = 8;
        head.next = n1;

        print(head);
        sort(head);
        print(head);
    }

    public static void print(ListNode head) {
        if (head == null) {
            return;
        }
        while (head.next != null) {
            System.out.print(head.value + "->");
            head = head.next;
        }
        System.out.println();
    }


}
