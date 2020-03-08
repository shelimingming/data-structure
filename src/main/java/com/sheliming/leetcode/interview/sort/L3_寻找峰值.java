package com.sheliming.leetcode.interview.sort;

/**
 * 峰值元素是指其值大于左右相邻值的元素。
 * <p>
 * 给定一个输入数组 nums，其中 nums[i] ≠ nums[i+1]，找到峰值元素并返回其索引。
 * <p>
 * 数组可能包含多个峰值，在这种情况下，返回任何一个峰值所在位置即可。
 * <p>
 * 你可以假设 nums[-1] = nums[n] = -∞。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,1]
 * 输出: 2
 * 解释: 3 是峰值元素，你的函数应该返回其索引 2。
 * 示例 2:
 * <p>
 * 输入: nums = [1,2,1,3,5,6,4]
 * 输出: 1 或 5
 * 解释: 你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5， 其峰值元素为 6。
 * 说明:
 * <p>
 * 你的解法应该是 O(logN) 时间复杂度的。
 */
public class L3_寻找峰值 {
    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 1] > nums[nums.length - 2]) {
            return nums.length - 1;
        }

        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    public int findPeakElement2(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1])
                return i;
        }
        return nums.length - 1;
    }

    public int findPeakElement3(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }

    private int search(int[] nums, int left, int right) {
        if (left == right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > nums[mid + 1]) {
            return search(nums, left, mid);
        }
        return search(nums, mid + 1, right);
    }


    public static void main(String[] args) {
        int[] a = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(new L3_寻找峰值().findPeakElement3(a));

    }
}
