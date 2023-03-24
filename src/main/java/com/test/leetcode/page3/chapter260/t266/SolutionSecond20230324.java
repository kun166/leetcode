package com.test.leetcode.page3.chapter260.t266;

/**
 * @ClassName: SolutionSecond20230324
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/24 16:28
 * @Version: 1.0
 */
public class SolutionSecond20230324 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.6 MB, 在所有 Java 提交中击败了22.28%的用户
     * 通过测试用例：24 / 24
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {

        boolean[] array = new boolean[26];
        for (char c : s.toCharArray()) {
            array[c - 'a'] = !array[c - 'a'];
        }
        int count = 0;
        for (boolean b : array) {
            if (b)
                count++;
        }
        return count < 2;
    }
}
