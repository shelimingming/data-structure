package com.sheliming.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L23_合并K个排序链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用堆
     *
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        PriorityQueue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val > o2.val) {
                    return 1;
                } else if (o1.val < o2.val) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });

        for (ListNode list : lists) {
            while (list != null) {
                queue.add(list);
                list = list.next;
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!queue.isEmpty()) {
            curr.next = queue.poll();
            curr = curr.next;
        }

        curr.next =null;

        return dummy.next;
    }

    /**
     * 使用分治法
     * @param lists
     * @return
     */
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return helper(lists,0,lists.length-1);

    }

    private ListNode helper(ListNode[] lists, int begin, int end) {
        if(begin==end) {
            return lists[begin];
        }else if(end-begin==1){
            return mergeTwoLists(lists[begin],lists[end]);
        } else {
            int mid = (begin+end)/2;
            return mergeTwoLists(helper(lists,begin,mid),helper(lists,mid+1,end));
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-2);
        ListNode l2 = new ListNode(-1);
        ListNode l3 = new ListNode(-1);
        ListNode l4 = new ListNode(-1);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListNode[] lists = new ListNode[2];
        lists[0] = l1;
        lists[1] = null;

        ListNode listNode = new L23_合并K个排序链表().mergeKLists(lists);
        while (listNode != null) {
            System.out.print(listNode.val + ",");
            listNode = listNode.next;
        }
    }
}
