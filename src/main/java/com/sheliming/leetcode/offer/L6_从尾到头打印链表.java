package com.sheliming.leetcode.offer;

import java.util.Stack;

public class L6_从尾到头打印链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用栈
     *
     * @param head
     * @return
     */
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<Integer>();
        int length = 0;
        while (head != null) {
            stack.push(head.val);
            head = head.next;
            length++;
        }
        int[] res = new int[length];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i] = stack.pop();
            i++;
        }

        return res;
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    public int[] reversePrint2(ListNode head) {

        //反转链表
        ListNode rev = reverse(head);

        return null;

    }

    private ListNode reverse(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode reverseHead = null;
        ListNode curr = head;
        ListNode pre = null;

        while (curr != null) {
            curr.next = pre;


            pre = curr;
            curr = curr.next;
        }

        return reverseHead;
    }

    /**
     * 使用递归
     * @param head
     * @return
     */
    public void reversePrint3(ListNode head) {
        if(head!=null) {
            if(head.next!=null) {
                reversePrint3(head.next);
            }
            System.out.println(head.val);
        }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        int[] ints = new L6_从尾到头打印链表().reversePrint(l1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }

        new L6_从尾到头打印链表().reversePrint3(l1);
    }
}
