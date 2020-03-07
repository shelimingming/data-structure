package com.sheliming.leetcode.interview.linklist;

public class L5_反转链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用循环
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode preNode = null;

        while(head!=null) {
            ListNode temp = head.next;
            head.next = preNode;
            preNode = head;
            head = temp;
        }

        return preNode;
    }

    /**
     * 使用递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head == null||head.next==null) {
            return head;
        }

        ListNode reverse = reverseList2(head.next);
        head.next.next = head;
        head.next = null;

        return reverse;
    }
}
