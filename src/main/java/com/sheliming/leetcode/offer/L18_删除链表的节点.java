package com.sheliming.leetcode.offer;

public class L18_删除链表的节点 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode deleteNode(ListNode head, int val) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            if (current.val == val) {
                if(pre == null) {
                    return current.next;
                } else {
                    pre.next = current.next;
                    return head;
                }
            } else {
                pre = current;
                current = current.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;


        ListNode listNode = new L18_删除链表的节点().deleteNode(l1, 2);
        while(listNode!=null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
