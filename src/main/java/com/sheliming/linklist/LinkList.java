package com.sheliming.linklist;

//https://www.cnblogs.com/smyhvae/p/4782595.html
public class LinkList {
    public Node head;//指向头结点
    public Node current;//指向最后一个节点

    public class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    //向链表中添加数据
    public void add(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            current = node;
        } else {
            current.next = node;
            current = current.next;
        }
    }

    //打印链表
    public String print(Node node) {
        if (node == null) {
            return null;
        }

        StringBuilder sb = new StringBuilder();

        Node current = node;
        while (current != null) {
            sb.append(current.data + ",");
            current = current.next;
        }

        System.out.println(sb.substring(0, sb.length() - 1));
        return sb.substring(0, sb.length() - 1);
    }

    //返回链表中节点的个数
    public int getLength() {
        if (head == null) {
            return 0;
        }

        Node current = head;
        int length = 0;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    //查找单链表中的倒数第k个结点
//    这里需要声明两个指针：
//    即两个结点型的变量first和second，首先让first和second都指向第一个结点，
//    然后让second结点往后挪k-1个位置，此时first和second就间隔了k-1个位置，
//    然后整体向后移动这两个节点，直到second节点走到最后一个结点的时候，
//    此时first节点所指向的位置就是倒数第k个节点的位置。时间复杂度为O（n）
    public Node findListNode(int index) {
        if (head == null || index == 0) {
            return null;
        }

        Node first = head;
        Node second = head;


        for (int i = 0; i < index - 1; i++) {
            second = second.next;
            if (second == null) {
                //说明index的值已经大于链表的长度了
                return null;
            }
        }

        while (second.next != null) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    /**
     * 合并两个有序的单链表，合并之后的链表依然有序：
     *
     * @param head1
     * @param head2
     * @return
     */
    public static Node mergeLinkList(Node head1, Node head2) {
        if (head1 == null && head2 == null) {
            return null;
        }
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        Node head;
        Node current;

        //一开始，我们让current结点指向head1和head2中较小的数据，得到head结点
        if (head1.data < head2.data) {
            head = head1;
            current = head1;
            head1 = head1.next;
        } else {
            head = head2;
            current = head2;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                current.next = head1;
                current = head1;
                head1 = head1.next;
            } else {
                current.next = head2;
                current = head2;
                head2 = head2.next;
            }
        }

        //合并剩余的元素
        if (head1 == null) {
            current.next = head2;
        }

        if (head2 == null) {
            current.next = head1;
        }

        return head;
    }

    /**
     * 返回当前链表的中间节点，（偶数节点返回中间靠后的一个节点）
     *
     * @return
     */
    public Node getMidNode() {
        return getMidNode(head);
    }

    /**
     * 返回以head节点为头的链表的中间节点，（偶数节点返回中间靠后的一个节点）
     * 使用快慢指针实现
     *
     * @param head
     * @return
     */
    public static Node getMidNode(Node head) {
        //没有节点返回null
        if (head == null) {
            return null;
        }
        //只有一个节点返回这个节点
        if (head.next == null) {
            return head;
        }


        Node first = head;
        Node second = head;

        while (second != null && second.next != null) {
            first = first.next;
            second = second.next.next;
        }

        return first;
    }

    /**
     * 返回以head节点为头的链表的中间节点，（偶数节点返回中间靠前的一个节点）
     * 使用快慢指针实现
     *
     * @param head
     * @return
     */
    public static Node getNodeBeforMidNode(Node head) {
        //没有节点返回null
        if (head == null) {
            return null;
        }
        //只有一个节点返回这个节点
        if (head.next == null) {
            return head;
        }

        Node before = null;
        Node first = head;
        Node second = head;

        while (second != null && second.next != null) {
            before = first;
            first = first.next;
            second = second.next.next;
        }

        return before;
    }

    //翻转链表(用循环)
    public static Node reverse(Node node) {
        Node preNode = null;
        while (node != null) {
            Node temp = node.next;
            node.next = preNode;
            preNode = node;
            node =temp;
        }
        return preNode;
    }

    //翻转链表(用递归)
    public static Node reverse2(Node node) {
        if(node == null || node.next == null) {
            return node;
        }
        Node reverseNode = reverse2(node.next);
        node.next.next = node;
        node.next = null;
        return reverseNode;
    }

    //判断链表是否有环
    public static boolean hasCycle(Node node) {
        if(node == null || node.next == null) {
            return false;
        }
        Node fast = node.next;
        Node slow = node;

        while(fast != slow) {
            if(fast==null||fast.next==null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return true;
    }

    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }
        linkList.print(linkList.head);
    }
}
