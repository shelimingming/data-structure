package com.sheliming.leetcode.offer;

import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 */
public class L52_两个链表的第一个公共节点 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

        /**
         * 使用额外的空间
         * 时间复杂度O（m+n）
         * 空间复杂度O(n)
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            HashSet<ListNode> set = new HashSet<ListNode>();
            while (headA != null) {
                set.add(headA);
                headA = headA.next;
            }

            while (headB != null) {
                if (set.contains(headB)) {
                    return headB;
                } else {
                    headB = headB.next;
                }
            }

            return null;
        }

        /**
         * 先计算两个链表的长度，再让长的先走差值，然后一起走，第一个遇到的就是交叉节点
         *
         * @param headA
         * @param headB
         * @return
         */
        public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
            int headALength = getListLength(headA);
            int headBLength = getListLength(headB);

            ListNode longList = null;
            ListNode shortList = null;
            int lengthDiff = 0;
            if (headALength >= headBLength) {
                longList = headA;
                shortList = headB;
                lengthDiff = headALength - headBLength;
            } else {
                longList = headB;
                shortList = headA;
                lengthDiff = headBLength - headALength;
            }

            //长的链表先走lengthDiff
            for (int i = 0; i < lengthDiff; i++) {
                longList = longList.next;
            }

            while (longList != null && longList != shortList) {
                longList = longList.next;
                shortList = shortList.next;
            }

            if (longList == shortList) {
                return longList;
            } else {
                return null;
            }
        }

        private int getListLength(ListNode head) {
            int lenght = 0;

            while (head != null) {
                lenght++;
                head = head.next;
            }

            return lenght;
        }
    }
}
