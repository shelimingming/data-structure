package com.sheliming.leetcode.interview.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个整数数组 nums，按要求返回一个新数组 counts。数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 * <p>
 * 示例:
 * <p>
 * 输入: [5,2,6,1]
 * 输出: [2,1,1,0]
 * 解释:
 * 5 的右侧有 2 个更小的元素 (2 和 1).
 * 2 的右侧仅有 1 个更小的元素 (1).
 * 6 的右侧有 1 个更小的元素 (1).
 * 1 的右侧有 0 个更小的元素.
 */
public class L5_计算右侧小于当前元素的个数 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i= 0;i<nums.length;i++) {
            int count = 0 ;
            for(int j=i+1;j<nums.length;j++) {
                if(nums[j]<nums[i]) {
                    count++;
                }
            }
            res.add(count);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {5,2,6,1};
        System.out.println(new L5_计算右侧小于当前元素的个数().countSmaller(nums));
    }
}
