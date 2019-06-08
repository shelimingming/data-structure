package com.sheliming.linklist;

import org.junit.Assert;
import org.junit.Test;

public class LinkListTest {

    /**
     * 测试查询链表总个数
     */
    @Test
    public void getLengthTest() {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }

        Assert.assertEquals("总个数不正确", 10, linkList.getLength());
    }

    /**
     * 测试返回倒数第k个结点
     */
    @Test
    public void findListNodeTest() {
        LinkList linkList = new LinkList();
        for (int i = 0; i < 10; i++) {
            linkList.add(i);
        }

        Assert.assertEquals("返回不正确", null, linkList.findListNode(100));
        Assert.assertEquals("返回不正确", null, linkList.findListNode(0));
        Assert.assertEquals("返回不正确", 9, linkList.findListNode(1).data);
        Assert.assertEquals("返回不正确", 7, linkList.findListNode(3).data);
        Assert.assertEquals("返回不正确", 0, linkList.findListNode(10).data);

    }

    /**
     * 合并两个链表
     */
    @Test
    public void mergeLinkListTest() {
        LinkList list1 = new LinkList();
        LinkList list2 = new LinkList();
        //向LinkList中添加数据
        for (int i = 0; i < 4; i++) {
            list1.add(i);
        }

        for (int i = 3; i < 8; i++) {
            list2.add(i);
        }

        LinkList list3 = new LinkList();
        list3.head = list3.mergeLinkList(list1.head, list2.head); //将list1和list2合并，存放到list3中

        Assert.assertEquals("0,1,2,3,3,4,5,6,7", list3.print(list3.head));
    }

    /**
     * 获取链表的中间节点
     */
    @Test
    public void getMidNodeTest() {
        LinkList list0 = new LinkList();
        LinkList.Node midNode0 = list0.getMidNode();
        Assert.assertEquals(null, midNode0);

        LinkList list1 = new LinkList();
        for (int i = 1; i <= 1; i++) {
            list1.add(i);
        }
        LinkList.Node midNode1 = list1.getMidNode();
        Assert.assertEquals(1, midNode1.data);

        LinkList list2 = new LinkList();
        for (int i = 1; i <= 2; i++) {
            list2.add(i);
        }
        LinkList.Node midNode2 = list2.getMidNode();
        Assert.assertEquals(2, midNode2.data);

        LinkList list3 = new LinkList();
        for (int i = 1; i <= 3; i++) {
            list3.add(i);
        }
        LinkList.Node midNode3 = list3.getMidNode();
        Assert.assertEquals(2, midNode3.data);

        LinkList list7 = new LinkList();
        for (int i = 1; i <= 7; i++) {
            list7.add(i);
        }
        LinkList.Node midNode7 = list7.getMidNode();
        Assert.assertEquals(4, midNode7.data);
    }

    /**
     * 测试链表翻转（用循环）
     */
    @Test
    public void reverseTest() {
        LinkList list = new LinkList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        LinkList.Node reverse = list.reverse(list.head);
        Assert.assertEquals("10,9,8,7,6,5,4,3,2,1", list.print(reverse));
    }

    /**
     * 测试链表翻转（用递归）
     */
    @Test
    public void reverse2Test() {
        LinkList list = new LinkList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        LinkList.Node reverse = list.reverse2(list.head);
        Assert.assertEquals("10,9,8,7,6,5,4,3,2,1", list.print(reverse));
    }

    /**
     * 测试链表是否有环
     */
    @Test
    public void hasCycleTest() {
        //测试无环
        LinkList list = new LinkList();
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
        boolean hasCycle = LinkList.hasCycle(list.head);
        Assert.assertEquals(false, hasCycle);
    }
}
