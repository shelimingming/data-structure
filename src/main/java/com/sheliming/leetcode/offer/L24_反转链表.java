package com.sheliming.leetcode.offer;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * <p>
 *  
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *  
 * <p>
 * 限制：
 * <p>
 * 0 <= 节点个数 <= 5000
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fan-zhuan-lian-biao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L24_反转链表 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 使用循环
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }

        ListNode reverseHead = null;
        ListNode current = head;
        ListNode next = null;
        while(current!=null) {
            next = current.next;
            current.next = reverseHead;
            reverseHead = current;
            current = next;
        }

        return reverseHead;
    }

    /**
     * 使用递归
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head) {
        if(head==null||head.next==null) {
            return head;
        }
        ListNode reverseNode  = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return reverseNode;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        l1.next = l2;
        l2.next = l3;

        ListNode listNode = new L24_反转链表().reverseList2(l1);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}
