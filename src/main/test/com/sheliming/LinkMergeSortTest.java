package com.sheliming;

import com.sheliming.linklist.LinkList;
import com.sheliming.sort.LinkMergeSort;
import org.junit.Assert;
import org.junit.Test;

public class LinkMergeSortTest {
    @Test
    public void linkMergeSortTest() {
        LinkList list1 = new LinkList();
        list1.add(1);
        LinkMergeSort.linkMergeSort(list1);
        Assert.assertEquals(1, list1.head.data);

        LinkList list2 = new LinkList();
        list2.add(2);
        list2.add(1);
        LinkMergeSort.linkMergeSort(list2);
        Assert.assertEquals(1, list2.head.data);
        Assert.assertEquals(2, list2.head.next.data);

        LinkList list3 = new LinkList();
        list3.add(2);
        list3.add(1);
        list3.add(3);
        LinkMergeSort.linkMergeSort(list3);
        Assert.assertEquals(1, list3.head.data);
        Assert.assertEquals(2, list3.head.next.data);
        Assert.assertEquals(3, list3.head.next.next.data);

        LinkList list4 = new LinkList();
        list4.add(43);
        list4.add(2);
        list4.add(110);
        list4.add(1);
        list4.add(43);
        list4.add(44);
        LinkMergeSort.linkMergeSort(list4);
        Assert.assertEquals(1, list4.head.data);
        Assert.assertEquals(2, list4.head.next.data);
        Assert.assertEquals(43, list4.head.next.next.data);
        Assert.assertEquals(43, list4.head.next.next.next.data);
        Assert.assertEquals(44, list4.head.next.next.next.next.data);
        Assert.assertEquals(110, list4.head.next.next.next.next.next.data);

    }
}
