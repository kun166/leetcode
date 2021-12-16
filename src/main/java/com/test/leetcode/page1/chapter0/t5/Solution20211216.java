package com.test.leetcode.page1.chapter0.t5;

/**
 * @ClassName: Solution20211216
 * @Description:
 * @Author: qinfajia
 * @Date: 2021/12/16 10:49
 * @Version: 1.0
 */
public class Solution20211216 {
    public String longestPalindrome(String s) {
        char[] charArray = s.toCharArray();
        int length = s.length();
        int start = 0, end = 0;
        for (int i = 1; i < length; i++) {
            if (charArray[i] == charArray[i - 1]) {
                // 本字符和后一个字符相同
                int st = i - 1, en = i;
                while (st > 0 && en < length - 1 && charArray[st - 1] == charArray[en + 1]) {
                    st--;
                    en++;
                }
                if (en - st > end - start) {
                    start = st;
                    end = en;
                }
            }
            // 以当前字符为边界判断
            int st = i, en = i;
            while (st > 0 && en < length - 1 && charArray[st - 1] == charArray[en + 1]) {
                st--;
                en++;
            }
            if (en - st > end - start) {
                start = st;
                end = en;
            }
        }
        return s.substring(start, end + 1);
    }
}
