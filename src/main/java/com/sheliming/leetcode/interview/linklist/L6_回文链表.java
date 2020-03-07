package com.sheliming.leetcode.interview.linklist;

/**
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class L6_回文链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    //
    public boolean isPalindrome(ListNode head) {
        ListNode mid = getMid(head);
        ListNode reverse = reverse(mid);

        while(head!=null)
        {
            if(head.val!=reverse.val){
                return false;
            }
            head = head.next;
            reverse = reverse.next;
        }
        return true;

        //恢复链表

    }

    //获取链表中间节点（偶数节点取后面一个）,并在之前断开
    public ListNode getMid(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;

        //记录断开的地方
        ListNode pre = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }

        pre.next = null;

        return slow;
    }

    //反转链表
    public ListNode reverse(ListNode head) {


        ListNode res = null;
        ListNode var = head;
        while (head != null) {
            var=head.next;
            head.next = res;
            res = head;
            head = var;
        }

        return res;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(1);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next= l5;

        boolean palindrome = new L6_回文链表().isPalindrome(l1);
        System.out.println(palindrome);
    }
}
