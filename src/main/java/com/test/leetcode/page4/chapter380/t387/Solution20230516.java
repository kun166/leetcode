package com.test.leetcode.page4.chapter380.t387;

/**
 * @ClassName: Solution20230516
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/16 09:42
 * @Version: 1.0
 */
public class Solution20230516 {

    /**
     * 执行用时：5 ms, 在所有 Java 提交中击败了84.41%的用户
     * 内存消耗：43.3 MB, 在所有 Java 提交中击败了5.02%的用户
     * 通过测试用例：105 / 105
     *
     * @param s
     * @return
     */
    public int firstUniqChar(String s) {
        int[] array = new int[26];
        for (char c : s.toCharArray()) {
            array[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (array[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
