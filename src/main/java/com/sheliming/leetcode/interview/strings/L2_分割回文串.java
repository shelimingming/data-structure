package com.sheliming.leetcode.interview.strings;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * <p>
 * 返回 s 所有可能的分割方案。
 * <p>
 * 示例:
 * <p>
 * 输入: "aab"
 * 输出:
 * [
 * ["aa","b"],
 * ["a","a","b"]
 * ]
 */
public class L2_分割回文串 {
    public List<List<String>> partition(String s) {
        return partitionHelper(s, 0);
    }

    public List<List<String>> partitionHelper(String s, int start) {
        if (start == s.length()) {
            List<List<String>> res = new ArrayList<List<String>>();
            List<String> list = new ArrayList<String>();
            res.add(list);
            return res;
        }

        List<List<String>> res = new ArrayList<List<String>>();
        for (int i = start; i < s.length(); i++) {
            String left = s.substring(start, i+1);
//            String right = s.substring(i + 1, s.length());
            if (isPalindrome(left)) {
                List<List<String>> list = partitionHelper(s, i + 1);
                for (List<String> l : list) {
                    l.add(0, left);
                }
                res.addAll(list);
            } else {
                continue;
            }
        }
        return res;
    }

    //判断是否是回文串
    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L2_分割回文串().isPalindrome("aba"));
        System.out.println(new L2_分割回文串().isPalindrome("abba"));
        System.out.println(new L2_分割回文串().isPalindrome("abc"));

        List<List<String>> aabb = new L2_分割回文串().partition("aabb");
        System.out.println(aabb);
    }
}
