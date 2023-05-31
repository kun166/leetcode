package com.test.leetcode.page5.chapter420.t422;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20230531
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/31 09:35
 * @Version: 1.0
 */
public class Solution20230531 {

    @Test
    public void test() {
        System.out.println(validWordSquare(Arrays.asList("abc", "bde", "cefg")));
    }

    /**
     * 执行用时：11 ms, 在所有 Java 提交中击败了57.14%的用户
     * 内存消耗：39.8 MB, 在所有 Java 提交中击败了98.41%的用户
     * 通过测试用例：35 / 35
     *
     * @param words
     * @return
     */
    public boolean validWordSquare(List<String> words) {
        // 这相当于方形二维数组
        if (words.get(0).length() != words.size()) {
            return false;
        }
        // 定义二维数字长度
        int n = words.size();
        for (int i = 0; i < n; i++) {
            // i行，第i行字符串。需要查找对应的第i列
            String word = words.get(i);
            if (word.length() > n) {
                return false;
            }
            for (int j = 0; j < word.length(); j++) {
                // j列，需要查找第j行
                // 第j行的单词长度不能小于i+1,否则words.get(j).charAt(i)会报越界异常
                if (words.get(j).length() < i + 1) {
                    return false;
                }
                if (word.charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
            // 从第word.length()行开始，字符串长度不能大于等于i+1,否则word已经结束了，但是这一列还有未比较的字符
            for (int j = word.length(); j < n; j++) {
                if (words.get(j).length() >= i + 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
