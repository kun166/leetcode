package com.test.leetcode.page3.chapter240.t243;

/**
 * @ClassName: Official202300313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 20:22
 * @Version: 1.0
 */
public class Official202300313 {
    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了61.03%的用户
     * 内存消耗：41.7 MB, 在所有 Java 提交中击败了54.93%的用户
     *
     * @param wordsDict
     * @param word1
     * @param word2
     * @return
     */
    public int shortestDistance(String[] wordsDict, String word1, String word2) {
        int length = wordsDict.length;
        int ans = length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < length; i++) {
            String word = wordsDict[i];
            if (word.equals(word1)) {
                index1 = i;
            } else if (word.equals(word2)) {
                index2 = i;
            }
            // 循环每一次都会执行，所以速度慢一些了
            if (index1 >= 0 && index2 >= 0) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }
}
