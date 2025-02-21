package com.test.leetcode.page5.chapter410.t412;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20230529
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/29 09:38
 * @Version: 1.0
 */
public class Solution20230529 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了98.58%的用户
     * 内存消耗：43.6 MB, 在所有 Java 提交中击败了12.09%的用户
     * 通过测试用例：8 / 8
     *
     * @param n
     * @return
     */
    public List<String> fizzBuzz(int n) {
        String[] array = new String[n];
        int start = 1, num;
        while ((num = start * 3) <= n) {
            array[num - 1] = "Fizz";
            start++;
        }
        start = 1;
        while ((num = start * 5) <= n) {
            array[num - 1] = (array[num - 1] == null ? "" : array[num - 1]) + "Buzz";
            start++;
        }
        for (int i = 1; i <= n; i++) {
            array[i - 1] = array[i - 1] == null ? i + "" : array[i - 1];
        }
        return Arrays.asList(array);
    }
}
