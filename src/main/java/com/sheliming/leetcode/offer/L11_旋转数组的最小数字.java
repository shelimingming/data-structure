package com.sheliming.leetcode.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 * <p>
 * 示例 1：
 * <p>
 * 输入：[3,4,5,1,2]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class L11_旋转数组的最小数字 {
    public int minArray(int[] numbers) {
        int begin = 0;
        int end = numbers.length-1;
        while (end-begin > 1) {
            int mid = (begin + end) / 2;
            if(numbers[mid]>=numbers[begin]) {
                begin = mid;
            }else {
                end = mid;
            }
        }
        return numbers[end];
    }

    public static void main(String[] args) {
        int[] numbers = {3, 4, 5, 1, 2};
        System.out.println(new L11_旋转数组的最小数字().minArray(numbers));
    }
}
