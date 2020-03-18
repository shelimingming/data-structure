package com.sheliming.leetcode.offer;

public class L16_数值的整数次方 {
    /**
     * 时间复杂度o(n)
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        if(n==0) {
            return 1;
        }
        double res = x;
        if(n>0) {
            for(int i=1;i<n;i++) {
                res *= x;
            }
            return res;
        }

        if(n<0) {
            for(int i=1;i<-n;i++) {
                res *= x;
            }
            return 1/res;
        }
        return 0;
    }




}
