package com.test.leetcode.page4.chapter380.t383;

/**
 * @ClassName: Solution20230516
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/16 08:59
 * @Version: 1.0
 */
public class Solution20230516 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了99.14%的用户
     * 内存消耗：42.7 MB, 在所有 Java 提交中击败了7.84%的用户
     * 通过测试用例：128 / 128
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] array = new int[26];
        for (char c : magazine.toCharArray()) {
            array[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--array[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
