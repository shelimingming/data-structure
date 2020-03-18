package com.sheliming;

import java.util.BitSet;

public class Test {
    public int getNum(int[] nums) {


        boolean[] bools = new boolean[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(nums[i] >nums.length || nums[i]<1) {
                nums[i] = 0;
            }
        }


        for(int i=0;i<nums.length;i++) {
            bools[nums[i]] = true;
        }

        for(int i=1;i<nums.length;i++) {
            if(bools[i] == false){
                return i;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Test().hashCode());


        int[] nums = {5, -1, 0, 3, 1, 2};
        System.out.println(new Test().getNum(nums));
    }
}
