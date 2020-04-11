package com.sheliming.sort;

/**
 * 通过一趟排序将待排记录分隔成独立的两部分，其中一部分记录的关键字均比另一部分的关键字小，
 * 则可分别对这两部分记录继续进行排序，以达到整个序列有序。
 *
 * 从数列中挑出一个元素，称为 “基准”（pivot）；
 * 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 *
 * 最佳情况：T(n) = O(nlogn)   最差情况：T(n) = O(n2)   平均情况：T(n) = O(nlogn)　
 */
public class QuickSort {


    public static void main(String[] args) {
        int[] a = {1, 2, 9, 4, 3, 1};
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();

        int[] a1 = {72, 6, 57, 88, 60, 42, 83, 73, 48, 85};
        quickSort(a1);
        for (int i = 0; i < a1.length; i++) {
            System.out.print(a1[i] + " ");
        }
    }

    private static void quickSort(int[] a) {
        recQuickSort(a, 0, a.length - 1);
    }

    private static void recQuickSort(int[] a, int left, int right) {
        if (left >= right) {
            return;
        }
        int privot = a[left];
        int partition = partitionIt(a, left, right, privot);
        recQuickSort(a, left, partition - 1);
        recQuickSort(a, partition + 1, right);
    }

    private static int partitionIt(int[] a, int left, int right, int privot) {
        int leftPtr = left;
        int rightPtr = right;
        while (true) {
            //一定要先从右边开始，防止基准就是最小值
            while (a[rightPtr] >= privot && leftPtr < rightPtr) {
                rightPtr--;
            }
            //一定要<=
            while (a[leftPtr] <= privot && leftPtr < rightPtr) {
                leftPtr++;
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(a, rightPtr, leftPtr);
            }
        }
        swap(a, left, rightPtr);
        return rightPtr;
    }

    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
