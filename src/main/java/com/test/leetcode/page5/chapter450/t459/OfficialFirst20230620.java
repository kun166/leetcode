package com.test.leetcode.page5.chapter450.t459;

import org.junit.Test;

/**
 * @ClassName: OfficialFirst20230620
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/20 09:58
 * @Version: 1.0
 */
public class OfficialFirst20230620 {

    @Test
    public void test() {
        System.out.println(repeatedSubstringPattern("abcabcabc"));
    }

    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i * 2 <= n; ++i) {
            if (n % i == 0) {
                boolean match = true;
                for (int j = i; j < n; ++j) {
                    // 下面这个判断牛逼啊
                    if (s.charAt(j) != s.charAt(j - i)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
        }
        return false;
    }
}
