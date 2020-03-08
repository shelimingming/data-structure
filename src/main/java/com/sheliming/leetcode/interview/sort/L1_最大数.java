package com.sheliming.leetcode.interview.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一组非负整数，重新排列它们的顺序使之组成一个最大的整数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [10,2]
 * 输出: 210
 * 示例 2:
 * <p>
 * 输入: [3,30,34,5,9]
 * 输出: 9534330
 * 说明: 输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 */
public class L1_最大数 {
    public String largestNumber(int[] nums) {
        String[] numss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numss[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(numss, new Comparator<String>() {
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;

//                if (Integer.parseInt(s1) > Integer.parseInt(s2)) {
//                    return -1;
//                }
//                return 0;
                return s2.compareTo(s1);
            }
        });

        if (numss[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < numss.length; i++) {
            sb.append(numss[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int[] nums = {999999998,999999997,999999999};
        System.out.println(new L1_最大数().largestNumber(nums));
    }
}
