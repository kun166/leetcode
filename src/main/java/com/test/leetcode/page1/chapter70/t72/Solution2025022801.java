package com.test.leetcode.page1.chapter70.t72;

/**
 * @ClassName: Solution2025022801
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/28 15:17
 * @Version: 1.0
 */
public class Solution2025022801 {

    int count = Integer.MAX_VALUE;

    /**
     * 这题不会做，只能尝试下递归回溯
     * <p>
     * 超出时间限制……
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        if (word1.length() < word2.length()) {
            String temp = word1;
            word1 = word2;
            word2 = temp;
        }
        backtrack(word1, word2, 0, 0, 0);
        return count;
    }

    public void backtrack(String word1, String word2, int i1, int i2, int operatorCount) {
        /**
         * "sea"
         * "eat"
         * 输出3
         * 预期2
         */
//        if (word1.length() - i1 < word2.length() - i2) {
//            // 始终保证word1剩余的字符串不少于word2的
//            return;
//        }
        if (i2 == word2.length()) {
            // word2已经比较结束了,返回
            count = Math.min(count, operatorCount + word1.length() - i1);
            return;
        }

        if (i1 == word1.length()) {
            // word2已经比较结束了,返回
            count = Math.min(count, operatorCount + word2.length() - i2);
            return;
        }


        if (word1.charAt(i1) == word2.charAt(i2)) {
            // 如果两个位置上的字符一致,直接比较下一个
            backtrack(word1, word2, i1 + 1, i2 + 1, operatorCount);
        } else {
            // 1,插入一个
            backtrack(word1, word2, i1, i2 + 1, operatorCount + 1);
            // 2,删除一个
            backtrack(word1, word2, i1 + 1, i2, operatorCount + 1);
            // 3,替换一个
            backtrack(word1, word2, i1 + 1, i2 + 1, operatorCount + 1);
        }
    }
}
