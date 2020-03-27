package com.sheliming.leetcode.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: 2
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: 0
 *  
 *
 * 限制：
 *
 * 0 <= 数组长度 <= 50000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L53_I在排序数组中查找数字 {
    /**
     * 二分法找到一个target，在先前和向后遍历计数
     * 最坏情况所有数字都是target，O（n）
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i=0;
        int j=nums.length-1;

        int mid = 0;
        boolean exist = false;

        while(i<=j) {
            mid = (i+j)/2;
            if(nums[mid] == target) {
                exist = true;
                break;
            }else if(nums[mid] > target){
                j = mid-1;
            } else{
                i=mid+1;
            }
        }

        if(!exist) {
            return 0;
        }

        int count = 1;
        for(int k=mid-1;k>=0&&nums[k]==target;k--) {
            count++;
        }
        for(int k=mid+1;k<nums.length&&nums[k]==target;k++) {
            count++;
        }
        return count;
    }



    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 8;
        System.out.println(new L53_I在排序数组中查找数字().search(nums,target));
    }
}
