package com.tengxun.list;

import java.util.PriorityQueue;

public class L23_合并K个排序链表 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists==null||lists.length==0) {
            return null;
        }
        return heaper(lists, 0, lists.length - 1);
    }

    private ListNode heaper(ListNode[] lists, int begin, int end) {
        if (begin == end) {
            return lists[begin];
        } else if (end - begin == 1) {
            return mergeTwoLists(lists[begin], lists[end]);
        } else {
            int mid = (begin + end) / 2;
            ListNode beginList = heaper(lists, begin, mid);
            ListNode endList = heaper(lists, mid + 1, end);
            ListNode listNode = mergeTwoLists(beginList, endList);
            return listNode;

        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
