package com.sheliming.leetcode.offer;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 * 还有一个 random 指针指向链表中的任意节点或者 null。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/fu-za-lian-biao-de-fu-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L35_复杂链表的复制 {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        HashMap<Node, Node> map = new HashMap<Node, Node>();

        Node dummy = new Node(-1);
        Node curr = dummy;
        while (head != null) {


            if (!map.containsKey(head)) {
                curr.next = new Node(head.val);
                curr = curr.next;
                map.put(head, curr);
            }else {
                curr.next = map.get(head);
                curr = curr.next;
            }

            if (head.random != null) {
                if (map.containsKey(head.random)) {
                    curr.random = map.get(head.random);
                } else {
                    Node random = new Node(head.random.val);
                    curr.random = random;
                    map.put(head.random, random);
                }
            }

            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Node n0 = new Node(7);
        Node n1 = new Node(13);
        Node n2 = new Node(11);
        Node n3 = new Node(10);
        Node n4 = new Node(1);
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        n1.random = n0;
        n2.random = n4;
        n3.random = n2;
        n4.random = n0;

        new L35_复杂链表的复制().copyRandomList(n0);
    }
}
