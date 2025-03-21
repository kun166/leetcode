package com.test.leetcode.page2.chapter150.t151;

/**
 * @ClassName: Solution2025032101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/21 09:57
 * @Version: 1.0
 */
public class Solution2025032101 {

    /**
     * 呃，先来个简单的吧
     * 呃，这个简单的还错了好几次……
     * 5ms	击败71.89%
     * 42.42MB	击败34.39%
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] array = s.split(" ");
        StringBuilder builder = new StringBuilder();
        builder.append(array[array.length - 1]);
        for (int i = array.length - 2; i >= 0; i--) {
            if (array[i] != "") {
                builder.append(" ").append(array[i]);
            }
        }
        return builder.toString();
    }
}
