package com.sheliming.linklist;

import org.junit.Assert;
import org.junit.Before;
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
}
