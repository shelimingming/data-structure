package com.sheliming.leetcode.offer;

/**
 * 0,1,,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 * <p>
 * 例如，0、1、2、3、4这5个数字组成一个圆圈，从数字0开始每次删除第3个数字，则删除的前4个数字依次是2、0、4、1，因此最后剩下的数字是3。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 5, m = 3
 * 输出: 3
 * 示例 2：
 * <p>
 * 输入: n = 10, m = 17
 * 输出: 2
 *  
 * <p>
 * 限制：
 * <p>
 * 1 <= n <= 10^5
 * 1 <= m <= 10^6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L62_圆圈中最后剩下的数字 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode pre;

        ListNode(int val) {
            this.val = val;
        }
    }

    public int lastRemaining(int n, int m) {
        if (n < 1 || m < 1) {
            return -1;
        }

        //构造环形链表
        ListNode head = new ListNode(0);

        ListNode curr = head;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode(i);
            node.pre = curr;
            curr.next = node;
            curr = curr.next;
        }
        curr.next = head;
        head.pre = curr;

        //模拟删除
        while (head.next != head) {
            for (int i = 1; i < m; i++) {
                head = head.next;
            }
            head.pre.next = head.next;
            head.next.pre = head.pre;
            head = head.next;
        }

        return head.val;
    }

    public static void main(String[] args) {
        System.out.println(new L62_圆圈中最后剩下的数字().lastRemaining(5, 2));
        System.out.println(new L62_圆圈中最后剩下的数字().lastRemaining(5, 1));
    }
}
