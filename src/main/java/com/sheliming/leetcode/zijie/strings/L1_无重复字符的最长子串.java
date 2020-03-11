package com.sheliming.leetcode.zijie.strings;

import java.util.HashSet;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class L1_无重复字符的最长子串 {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set =  new HashSet<Character>();
        int longestLenght = 0 ;
        int currentLength = 0;
        int front = 0 ;
        for(int back=0;back < s.length();back++) {
            if(set.contains(s.charAt(back))) {
                while(s.charAt(front)!=s.charAt(back)) {
                    set.remove(s.charAt(front));
                    currentLength--;
                    front ++;
                }
                front ++;
            }else {
                set.add(s.charAt(back));
                currentLength++;
                if(currentLength>longestLenght) {
                    longestLenght = currentLength;
                }

            }
        }
        return longestLenght;
    }

    public static void main(String[] args) {
        System.out.println(new L1_无重复字符的最长子串().lengthOfLongestSubstring("aabaab!bb"));
        System.out.println(new L1_无重复字符的最长子串().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new L1_无重复字符的最长子串().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new L1_无重复字符的最长子串().lengthOfLongestSubstring("pwwkew"));
    }
}
