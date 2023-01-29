package com.test.leetcode.erery;

import org.junit.Test;

/**
 * @ClassName: Official2315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/29 09:09
 * @Version: 1.0
 */
public class Official2315 {

    @Test
    public void test() {
        System.out.println(countAsterisks("123*|*1"));
    }

    /**
     * 注意，每个竖线 '|' 都会 恰好 属于一个对。
     *
     * @param s
     * @return
     */
    public int countAsterisks(String s) {
        boolean valid = true;
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '|') {
                valid = !valid;
            } else if (c == '*' && valid) {
                res++;
            }
        }
        return res;
    }
}
