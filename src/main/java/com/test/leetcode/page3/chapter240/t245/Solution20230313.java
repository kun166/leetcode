package com.test.leetcode.page3.chapter240.t245;

/**
 * @ClassName: Solution20230313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 21:08
 * @Version: 1.0
 */
public class Solution20230313 {
    public int shortestWordDistance(String[] wordsDict, String word1, String word2) {
        int min = Integer.MAX_VALUE;
        if (word1.equals(word2)) {
            int index = -1;
            for (int i = 0; i < wordsDict.length; i++) {
                if (wordsDict[i].equals(word1)) {
                    if (index == -1) {
                        index = i;
                    } else {
                        min = Math.min(min, i - index);
                        index = i;
                    }
                }
            }
        } else {
            int index1 = -1, index2 = -1;
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
        }
        return min;
    }
}
