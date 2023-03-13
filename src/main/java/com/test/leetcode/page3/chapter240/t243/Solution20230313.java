package com.test.leetcode.page3.chapter240.t243;

/**
 * @ClassName: Solution20230313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 20:07
 * @Version: 1.0
 */
public class Solution20230313 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98%的用户
     * 内存消耗：42 MB, 在所有 Java 提交中击败了13%的用户
     *
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int index1 = -1, index2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < wordsDict.length; i++) {
            if (wordsDict[i].equals(word1)) {
                if (index2 != -1) {
                    min = Math.min(min, i - index2);
                }
                index1 = i;
            } else if (wordsDict[i].equals(word2)) {
                if (index1 != -1) {
                    min = Math.min(min, i - index1);
                }
                index2 = i;
            }
        }
        return min;
    }
}
