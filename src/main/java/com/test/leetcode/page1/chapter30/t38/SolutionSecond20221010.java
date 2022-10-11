package com.test.leetcode.page1.chapter30.t38;

import org.junit.Test;

/**
 * @ClassName: SolutionSecond20221010
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/10 19:38
 * @Version: 1.0
 */
public class SolutionSecond20221010 {
    @Test
    public void test() {
        System.out.println(countAndSay(5));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String str = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                builder.append(count).append(str.charAt(i - 1));
                count = 1;
            }
        }
        builder.append(count).append(str.charAt(str.length() - 1));
        return builder.toString();
    }
}
