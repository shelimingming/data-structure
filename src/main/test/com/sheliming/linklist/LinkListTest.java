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
}
