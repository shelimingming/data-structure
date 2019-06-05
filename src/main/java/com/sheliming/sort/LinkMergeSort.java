package com.sheliming.sort;

import com.sheliming.linklist.LinkList;

/**
 * 链表的归并排序
 */
public class LinkMergeSort {

    public static void linkMergeSort(LinkList linkList) {
        LinkList.Node head = linkList.head;
        LinkList.Node res = mergeSort(head);
        linkList.head = res;

    }

    static LinkList.Node mergeSort(LinkList.Node node) {
        if (node == null) {
            return null;
        }
        if (node.next == null) {
            return node;
        }

        //将链表分成左右两个部分分别进行归并排序
        LinkList.Node right = mergeSort(LinkList.getMidNode(node));
        LinkList.getNodeBeforMidNode(node).next = null; //将链表从中间节点的前面断开
        LinkList.Node left = mergeSort(node);

        LinkList.Node res = LinkList.mergeLinkList(left, right);

        return res;
    }

}
