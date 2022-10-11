package com.test.leetcode.page1.chapter30.t38;

import org.junit.Test;

/**
 * @ClassName: Solution20221010
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/10 19:26
 * @Version: 1.0
 */
public class Solution20221010 {

    @Test
    public void test() {
        System.out.println(countAndSay(5));
    }

    public String countAndSay(int n) {
        String ans = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            int count = 1;
            for (int j = 1; j < ans.length(); j++) {
                if (ans.charAt(j) == ans.charAt(j - 1)) {
                    count++;
                } else {
                    builder.append(count).append(ans.charAt(j - 1));
                    count = 1;
                }
            }
            builder.append(count).append(ans.charAt(ans.length() - 1));
            ans = builder.toString();
        }
        return ans;
    }
}
