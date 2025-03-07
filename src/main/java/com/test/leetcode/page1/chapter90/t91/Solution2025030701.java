package com.test.leetcode.page1.chapter90.t91;

import org.junit.Test;

/**
 * @ClassName: Solution2025030701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/7 08:50
 * @Version: 1.0
 */
public class Solution2025030701 {

    @Test
    public void test() {
        System.out.println(numDecodings("1234"));
    }

    /**
     * 这题和第70题很相似
     *
     * @param s
     * @return
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        if (s.length() == 1)
            return 1;
        int first = 1;
        int second = match(s, 1);
        if (second == 0)
            return 0;
        second = second == 3 ? 2 : 1;
        for (int i = 2; i < s.length(); i++) {
            int number = match(s, i);
            if (number == 0)
                return 0;
            else if (number == 1) {
                // 不能组合，能拆分 f(n) = f(n-1)
                first = second;
            } else if (number == 2) {
                // 能组合,不能拆分 f(n) = f(n-2)
                int temp = first;
                first = second;
                second = temp;
            } else {
                // 技能拆分,又能组合 f(n) = f(n-1)+f(n-2);
                int temp = first + second;
                first = second;
                second = temp;
            }
        }
        return second;

    }

    int match(String s, int index) {
        // 和前一个数能组合,也能拆分  1,2
        // 和前一个数能组合,不能拆分  1,0
        // 和前一个数不能组合，能拆分 0,1
        // 和前一个数既不能组合,也不能拆分,3,0  0,0
        int number = Integer.parseInt(s.substring(index - 1, index + 1));
        if (number > 10 && number <= 26 && number != 20) {
            // 能组合，能拆分
            return 3;
        } else if (number == 0 || (number > 26 && number % 10 == 0)) {
            // 不能组合，不能拆分
            return 0;
        } else if (number < 10 || number > 26) {
            // 只能拆分，不能组合
            return 1;
        } else
            // 只能组合，不能拆分
            return 2;
    }
}
