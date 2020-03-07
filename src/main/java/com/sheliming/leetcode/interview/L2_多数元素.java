package com.sheliming.leetcode.interview;

import java.util.HashMap;

/**
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 * <p>
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class L2_多数元素 {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        int half = nums.length / 2;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            if (map.get(nums[i]) > half) {
                return nums[i];
            }
        }
        throw new RuntimeException("");
    }

    //在原序列中除去两个不同的元素后，那么在原序列中的多数元素在新序列中还是多数元素。
    public int majorityElement2(int[] nums) {
        int res = nums[0];
        int times = 1;
        for (int i = 1; i < nums.length; i++) {
            if (times == 0) {
                res = nums[i];
                times++;
                continue;
            }
            if (nums[i] != res) {
                times--;
                continue;
            }
            if (nums[i] == res) {
                times++;
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {6,6,6,7,7};
        int i = new L2_多数元素().majorityElement2(nums);
        System.out.println(i);
    }
}
