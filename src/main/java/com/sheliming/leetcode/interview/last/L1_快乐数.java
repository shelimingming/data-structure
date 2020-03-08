package com.sheliming.leetcode.interview.last;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 * <p>
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 * <p>
 * 示例:
 * <p>
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class L1_快乐数 {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;
        do {
            slow = next(slow);
            fast = next(fast);
            fast = next(fast);
        } while (slow != fast);

        return slow == 1;
    }

    public int next(int n) {
        int next = 0;
        while (n > 0) {
            int bit = n % 10;
            next += bit * bit;
            n = n / 10;
        }
        return next;
    }
}
