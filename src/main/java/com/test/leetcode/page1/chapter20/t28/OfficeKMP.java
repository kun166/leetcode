package com.test.leetcode.page1.chapter20.t28;

/**
 * @ClassName: OfficeKMP
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/9 09:40
 * @Version: 1.0
 */
public class OfficeKMP {

    /**
     * KMP算法，可以参考这篇文章
     * https://www.zhihu.com/question/21923021/answer/281346746
     * 以下官方代码的实现，并没有用到pmt的next，不太一样
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
        int[] pi = new int[m];
        // 下面这个循环，是速求needle的pmt数组
        // 为什么i从1开始？因为0的话，就是一个字符，匹配度为0。即pi[0]永远为0。且从0开始求的也不正确
        // 求公共前后缀，前缀不算最后一个字符，后缀不算第一个字符。公共前后缀不算字符串本身
        for (int i = 1, j = 0; i < m; i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                // 说明不匹配。如果不匹配，就从j的上一个位置的pmt开始匹配
                j = pi[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                // 匹配就加1
                j++;
            }
            pi[i] = j;
        }
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }
}
