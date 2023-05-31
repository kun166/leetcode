package com.test.leetcode.page5.chapter410.t418;

import org.junit.Test;

/**
 * @ClassName: Solution20230530
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/30 15:10
 * @Version: 1.0
 */
public class Solution20230530 {

    @Test
    public void test() {
        System.out.println(wordsTyping(new String[]{"f", "p", "a"}, 8, 7));
    }

    /**
     * 执行用时：2274 ms, 在所有 Java 提交中击败了18.33%的用户
     * 内存消耗：38.9 MB, 在所有 Java 提交中击败了75.00%的用户
     * 通过测试用例：51 / 51
     *
     * @param sentence
     * @param rows
     * @param cols
     * @return
     */
    public int wordsTyping(String[] sentence, int rows, int cols) {
        int count = 0, start = 0;
        for (int i = 0; i < rows; i++) {
            // 遍历每一行
            // 这个地方一定是-1啊，错了好多次
            int j = -1;
            while (true) {
                int end = (j == -1 ? j : j + 1) + sentence[start].length();
                if (end < cols) {
                    // 本行能显示第start个单词
                    j = end;
                    if (start == sentence.length - 1) {
                        count++;
                        start = 0;
                    } else {
                        start++;
                    }
                } else {
                    // 下一行了
                    break;
                }
            }
        }
        return count;
    }
}
