package com.test.leetcode.page3.chapter260.t266;

/**
 * @ClassName: Other20230324
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/24 17:33
 * @Version: 1.0
 */
public class Other20230324 {

    /**
     * 这大神的代码，真的是牛逼啊
     *
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        int cs = 0;
        for (char c : s.toCharArray()) {
            cs ^= (1 << (c - 'a'));
        }
        cs &= (cs - 1);
        return cs == 0;
    }
}
