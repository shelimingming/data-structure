package com.sheliming.dp;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class L5_最长回文子串 {
    /**
     * 暴力法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String maxString = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length() + 1; j++) {
                if (isPalindrome(s.substring(i, j)) && (j - i + 1) > maxString.length()) {
                    maxString = s.substring(i, j);
                }
            }
        }

        return maxString;
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public String longestPalindrome2(String s) {
        boolean isPalindrome[][] = new boolean[s.length() + 1][s.length() + 1];
        String maxString = "";
        for (int j = 0; j <= s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                if (j - i <= 1 || j - i == 2 && (s.charAt(i) == s.charAt(j - 1))) {
                    isPalindrome[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j - 1) && isPalindrome[i + 1][j - 1] == true) {
                    isPalindrome[i][j] = true;
                }
                if (i != j && isPalindrome[i][j] == true && maxString.length() < (j - i)) {
                    maxString = s.substring(i, j);
                }
            }
        }
        return maxString;
    }

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
        //System.out.println(new L5_最长回文子串().longestPalindrome("abbc"));
        System.out.println(new L5_最长回文子串().longestPalindrome2("abcba"));

    }
}
