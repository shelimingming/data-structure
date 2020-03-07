package com.sheliming.sort;

import com.sheliming.linklist.LinkList;

/**
 * 链表的归并排序
 *
 * 归并排序的一般步骤为：
 * 将待排序数组（链表）取中点并一分为二；
 * 递归地对左半部分进行归并排序；
 * 递归地对右半部分进行归并排序；
 * 将两个半部分进行合并（merge）,得到结果。
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
