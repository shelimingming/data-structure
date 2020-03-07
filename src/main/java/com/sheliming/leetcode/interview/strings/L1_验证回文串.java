package com.sheliming.leetcode.interview.strings;

public class L1_验证回文串 {
    public boolean isPalindrome(String s) {
        int left=0;
        int right=s.length()-1;
        while(left<=right) {
            while (!Character.isLetterOrDigit(s.charAt(left))) {
                //增加判断，不然"./"会越界
                if(left<right) {
                    left++;
                }else {
                    return true;
                }
            }
            while (!Character.isLetterOrDigit(s.charAt(right))) {
                if(left<right) {
                    right--;
                }else {
                    return true;
                }
            }
            if(Character.toLowerCase(s.charAt(left))!=Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean palindrome = new L1_验证回文串().isPalindrome("A man, a plan, a canal: Panama");
        System.out.println(palindrome);

        boolean palindrome2 = new L1_验证回文串().isPalindrome("");
        System.out.println(palindrome);

        boolean palindrome3 = new L1_验证回文串().isPalindrome(" ");
        System.out.println(palindrome);

        boolean palindrome4 = new L1_验证回文串().isPalindrome("./");
        System.out.println(palindrome);
    }
}
