package com.tengxun.list;

public class L25_合并两个排序的链表 {
    public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) {
//            return l2;
//        }
//        if (l2 == null) {
//            return l1;
//        }
//
//        ListNode head = null;
//        if (l1.val < l2.val) {
//            head = l1;
//            l1 = l1.next;
//        } else {
//            head = l2;
//            l2 = l2.next;
//        }
//
//        ListNode curr = head;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                curr.next = l1;
//                l1 = l1.next;
//                curr = curr.next;
//            } else {
//                curr.next = l2;
//                l2 = l2.next;
//                curr = curr.next;
//            }
//        }
//
//        if (l1 != null) {
//            curr.next = l1;
//        }
//        if (l2 != null) {
//            curr.next = l2;
//        }
//
//        return head;
//    }

//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode dummy = new ListNode(-1);
//
//        ListNode curr = dummy;
//        while (l1 != null && l2 != null) {
//            if (l1.val < l2.val) {
//                curr.next = l1;
//                l1 = l1.next;
//                curr = curr.next;
//            } else {
//                curr.next = l2;
//                l2 = l2.next;
//                curr = curr.next;
//            }
//        }
//
//        if (l1 != null) {
//            curr.next = l1;
//        }
//        if (l2 != null) {
//            curr.next = l2;
//        }
//
//        return dummy.next;
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) {
            return l2;
        }else if(l2 == null) {
            return l1;
        } else if(l1.val <l2.val) {
            l1.next = mergeTwoLists(l1.next,l2);
            return l1;
        } else  {
            l2.next = mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
