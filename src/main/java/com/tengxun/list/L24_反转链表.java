package com.tengxun.list;

public class L24_反转链表 {
    public static  class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

//    public ListNode reverseList(ListNode head) {
//        if(head==null||head.next==null) {
//            return head;
//        }
//
//        ListNode reverseNode = null;
//        ListNode curr = head;
//        ListNode nextNode = curr;
//
//        while(curr!=null) {
//            nextNode = curr.next;
//            curr.next = reverseNode;
//            reverseNode = curr;
//            curr = nextNode;
//        }
//
//        return reverseNode;
//    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }

        ListNode reverseNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode listNode = new L24_反转链表().reverseList(l1);

        while(listNode != null) {
            System.out.print(listNode.val+",");
            listNode = listNode.next;
        }
    }
}
