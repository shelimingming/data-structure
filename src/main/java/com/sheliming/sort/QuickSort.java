package com.sheliming.sort;

public class QuickSort {


    public static void main(String[] args) {
        int[] a = {1, 2, 9, 4, 3, 1};
        quickSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i] + " ");
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
        int leftPtr = left + 1;
        int rightPtr = right;
        while (true) {
            while (a[leftPtr] < privot) {
                leftPtr++;
            }
            while (a[rightPtr] > privot) {
                rightPtr--;
            }
            if (leftPtr >= rightPtr) {
                break;
            } else {
                swap(a[rightPtr], a[leftPtr]);
            }
        }
        swap(a[left], a[rightPtr]);
        return rightPtr;
    }

    private static void swap(int i, int j) {
        int temp = i;
        i = j;
        j = temp;
    }
}
