package com.sheliming.leetcode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 * <p>
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 * <p>
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/add-two-numbers
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L2_两数相加 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        //哑结点
        ListNode res = new ListNode(0);
        int up = 0;
        int sum = 0;
        ListNode curr = res;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int all = x + y + up;
            up = all / 10;
            sum = all % 10;


            ListNode temp = new ListNode(sum);
            curr.next = temp;
            curr = curr.next;

            if(l1!=null){
                l1=l1.next;
            }

            if(l2!=null) {
                l2=l2.next;
            }

        }

        if(up != 0) {
            ListNode temp = new ListNode(up);
            curr.next = temp;
        }

        return res.next;
    }

    public static void main(String[] args) {
    }
}
