package com.sheliming.leetcode.offer;

public class L23_链表中环的入口节点 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode getEnter(ListNode head) {

        //先看是否有环，并计算环内节点个个数
        int cycleLength = getCycleLength(head);
        if (cycleLength == 0) {
            return null;
        }

        //使用快慢指针，第一个指针先走环的个数，再同时走，相遇的地方即为环的入口
        ListNode slow = head;
        ListNode fast = head;
        while (cycleLength != 0) {
            fast = fast.next;
            cycleLength--;
        }
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    private int getCycleLength(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int lenght = 1;
                fast = fast.next;
                while (slow != fast) {
                    fast = fast.next;
                    lenght++;
                }
                return lenght;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;

        ListNode enter = new L23_链表中环的入口节点().getEnter(l1);
        System.out.println(enter.val);
    }
}
