package com.sheliming.leetcode.interview.linklist;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 * <p>
 * 要求返回这个链表的 深拷贝。
 * <p>
 * 我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * <p>
 * val：一个表示 Node.val 的整数。
 * random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 */
public class L1_复制带随机指针的链表 {
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

    //key-value :老节点-新节点
    Map<Node, Node> map = new HashMap<Node, Node>();

    //时间O(N) 空间O(N)
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        if (map.containsKey(head)) {
            return map.get(head);
        }

        Node node = new Node(head.val);
        map.put(head, node);

        node.next = copyRandomList(head.next);
        node.random = copyRandomList(head.random);

        return node;
    }

    //时间o(N) 空间o(N)
    public Node copyRandomList2(Node head) {
        if (head == null) {
            return null;
        }

        //1.遍历原来的链表并拷贝每一个节点，将拷贝节点放在原来节点的旁边，创造出一个旧节点和新节点交错的链表。
        Node ptr = head;
        while (ptr != null) {
            Node node = new Node(ptr.val);
            node.next = ptr.next;
            ptr.next = node;

            ptr = node.next;
        }

        //2.迭代这个新旧节点交错的链表，并用旧节点的 random 指针去更新对应新节点的 random 指针。
        ptr = head;
        while (ptr != null) {
            ptr.next.random = ptr.random != null ? ptr.random.next : null;
            ptr = ptr.next.next;
        }

        //3.现在 random 指针已经被赋值给正确的节点， next 指针也需要被正确赋值，以便将新的节点正确链接同时将旧节点重新正确链接。
        ptr = head;
        Node newList = head.next;
        while (ptr!=null) {
            Node  val = ptr.next.next;
            ptr.next.next = ptr.next.next!=null?ptr.next.next.next:null;
            ptr.next = val;
            ptr = ptr.next;
        }

        return newList;
    }

    public static void main(String[] args) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.next = node1;
        node0.random = null;

        node1.next = node2;
        node1.random = node0;

        node2.next = node3;
        node2.random = node4;

        node3.next = node4;
        node3.random = node2;

        node4.next = null;
        node4.random = node0;

        Node node = new L1_复制带随机指针的链表().copyRandomList2(node0);
        while (node!=null) {
            System.out.println(node.val+",");
            node = node.next;
        }

        while (node0!=null) {
            System.out.println(node0.val+",");
            node0 = node0.next;
        }
    }

}
