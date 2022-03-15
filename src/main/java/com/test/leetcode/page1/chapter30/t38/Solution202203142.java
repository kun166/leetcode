package com.test.leetcode.page1.chapter30.t38;

import org.junit.Test;

/**
 * @ClassName: Solution202203142
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/3/14 20:14
 * @Version: 1.0
 */
public class Solution202203142 {

    @Test
    public void test() {
        System.out.println(countAndSay(4));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            return "11";
        }
        int index = 2;
        StringBuilder builder = new StringBuilder("11");
        while (index < n) {
            int count = 1;
            StringBuilder secondBuilder = new StringBuilder();
            for (int i = 1; i < builder.length(); i++) {
                if (builder.charAt(i) == builder.charAt(i - 1)) {
                    count++;
                } else {
                    secondBuilder.append((char) (count + '0')).append(builder.charAt(i - 1));
                    count = 1;
                }
            }
            secondBuilder.append((char) (count + '0')).append(builder.charAt(builder.length() - 1));
            index++;
            builder = secondBuilder;
        }
        return builder.toString();
    }
}
