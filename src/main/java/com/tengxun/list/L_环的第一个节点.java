package com.tengxun.list;

public class L_环的第一个节点 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getCycleFirst(ListNode head) {
        //获取环的长度
        int cycLength = getCycLength(head);

        if(cycLength == 0) {
            throw new RuntimeException("链表没有环");
        }

        ListNode fast = head;
        ListNode slow = head;

        for(int i=0;i<cycLength;i++) {
            fast = fast.next;
        }

        while(fast!=slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return slow;
    }

    private int getCycLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode fast = head;
        ListNode slow = head;

        int length = 0;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                fast = fast.next;
                length++;
                while (fast != slow) {
                    fast = fast.next;
                    length++;
                }
                return length;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        System.out.println(new L_环的第一个节点().getCycleFirst(l1).val);
    }
}
