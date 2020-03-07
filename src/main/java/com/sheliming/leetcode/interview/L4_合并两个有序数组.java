package com.sheliming.leetcode.interview;

public class L4_合并两个有序数组 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for(int i=0;i<nums2.length;i++) {
            for(int j=0;j<nums1.length;j++) {
                if(nums2[i]>nums1[j]) {

                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

        new L4_合并两个有序数组().merge(nums1,m,nums2,n);

        for(int i=0;i<nums1.length;i++) {
            System.out.println(nums1[i]+",");
        }
    }
}
