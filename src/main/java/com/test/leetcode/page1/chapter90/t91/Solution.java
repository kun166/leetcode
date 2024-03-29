package com.test.leetcode.page1.chapter90.t91;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-03 16:48
 */
public class Solution {

    @Test
    public void test() {
//        String[] array = {"12", "0", "226", "2101", "10"};
//        for (String s : array) {
//            System.out.println(s + ":" + numDecodings(s));
//        }
        System.out.println(numDecodings("1012"));
    }

    public int numDecodings(String s) {
        return getAns(s, 0);
    }

    private int getAns(String s, int start) {
        //划分到了最后返回 1
        if (start == s.length()) {
            return 1;
        }
        //开头是 0,0 不对应任何字母，直接返回 0
        if (s.charAt(start) == '0') {
            return 0;
        }
        //得到第一种的划分的解码方式
        int ans1 = getAns(s, start + 1);
        int ans2 = 0;
        //判断前两个数字是不是小于等于 26 的
        if (start < s.length() - 1) {
            int ten = (s.charAt(start) - '0') * 10;
            int one = s.charAt(start + 1) - '0';
            if (ten + one <= 26) {
                ans2 = getAns(s, start + 2);
            }
        }
        return ans1 + ans2;
    }

}
