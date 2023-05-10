package com.test.leetcode.page4.chapter340.t344;

/**
 * @ClassName: Solution20230506
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/6 11:21
 * @Version: 1.0
 */
public class Solution20230506 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：49.8 MB, 在所有 Java 提交中击败了5.03%的用户
     * 通过测试用例：477 / 477
     *
     * @param s
     */
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            char mid = s[left];
            s[left] = s[right];
            s[right] = mid;
            left++;
            right--;
        }
    }
}
