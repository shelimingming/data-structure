package com.sheliming.sort;

/**
 * 计数排序要求输入的数据必须是有确定范围的整数。
 *
 * 找出待排序的数组中最大和最小的元素；
 * 统计数组中每个值为i的元素出现的次数，存入数组C的第i项；
 * 对所有的计数累加（从C中的第一个元素开始，每一项和前一项相加）；
 * 反向填充目标数组：将每个元素i放在新数组的第C(i)项，每放一个元素就将C(i)减去1。
 *
 * 最佳情况：T(n) = O(n+k)  最差情况：T(n) = O(n+k)  平均情况：T(n) = O(n+k)
 */
public class CountingSort {
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

    public static void sort(int[] a) {

    }
}
