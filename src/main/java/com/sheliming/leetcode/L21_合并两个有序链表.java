package com.sheliming.leetcode;

import java.util.List;

/**
 * 将两个升序链表合并为一个新的升序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-two-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L21_合并两个有序链表 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;

        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.val >= l2.val) {
            head = l2;
            l2 = l2.next;
        }else if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        }

        ListNode curr = head;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            } else {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
        }

        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return head;
    }

    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);

        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                curr.next = l2;
                curr = curr.next;
                l2 = l2.next;
            } else {
                curr.next = l1;
                curr = curr.next;
                l1 = l1.next;
            }
        }

        if (l1 != null) {
            curr.next = l1;
        }
        if (l2 != null) {
            curr.next = l2;
        }

        return dummy.next;
    }

    /**
     * 递归法
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }else if (l2 == null) {
            return l1;
        } else if(l1.val<=l2.val) {
            l1.next = mergeTwoLists2(l1.next,l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l2.next,l1);
            return l2;
        }


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;

        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode listNode = new L21_合并两个有序链表().mergeTwoLists1(l1, l4);
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }
}
