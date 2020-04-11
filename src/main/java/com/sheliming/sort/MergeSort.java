package com.sheliming.sort;

/**
 * 分治法
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * 最佳情况：T(n) = O(n)  最差情况：T(n) = O(nlogn)  平均情况：T(n) = O(nlogn)
 * 稳定
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 9, 4, 3, 1};
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        int[] a1 = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        sort(a1);
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
    }

    public static void sort(int[] array) {

    }
}
