package com.sheliming.sort;

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
