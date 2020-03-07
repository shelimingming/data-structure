package com.sheliming.leetcode.interview.linklist;

import com.sheliming.linklist.LinkList;

import java.util.List;

public class L3_排序链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 归并排序
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        //找到链表的中间节点
        ListNode mid = getMid(head);

        ListNode listLeft = sortList(head);
        ListNode listRight = sortList(mid);

        ListNode merge = merge(listLeft, listRight);

        return merge;
    }

    /**
     * 合并两个有序链表，结果还是有序
     *
     * @param n1
     * @param n2
     * @return
     */
    public ListNode merge(ListNode n1, ListNode n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        ListNode head = null;
        ListNode current = null;
        if (n1.val > n2.val) {
            head = n2;
            current = n2;
            n2 = n2.next;
        } else {
            head = n1;
            current = n1;
            n1 = n1.next;
        }

        while(n1!=null&&n2!=null) {
            if(n1.val<n2.val) {
                current.next = n1;
                n1= n1.next;
                current = current.next;
            } else {
                current.next = n2;
                n2= n2.next;
                current = current.next;
            }
        }

        if(n1==null) {
            current.next = n2;
        }
        if(n2==null) {
            current.next = n1;
        }

        return head;

    }

    /**
     * 获取链表的中间节点,并从中间节点截断
     *
     * @param head
     * @return
     */
    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        ListNode before = null; //为了截断
        while (fast != null && fast.next != null) {
            before = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        before.next = null;

        return slow;
    }

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(4);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(1);
//        ListNode n4 = new ListNode(3);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;

        ListNode n1 = new ListNode(-1);
        ListNode n2 = new ListNode(5);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(0);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ListNode list = new L3_排序链表().sortList(n1);

        while (list!=null) {
            System.out.print(list.val+",");
            list=list.next;
        }
    }
}
