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
        // 一个int是32位，足够存储26个字符
        int cs = 0;
        // 相当于每一位是一个boolean值
        for (char c : s.toCharArray()) {
            cs ^= (1 << (c - 'a'));
        }
        // 最后的cs至多包含一个1
        cs &= (cs - 1);
        return cs == 0;
    }
}
