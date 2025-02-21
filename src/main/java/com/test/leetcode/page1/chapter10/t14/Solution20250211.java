package com.test.leetcode.page1.chapter10.t14;

import org.junit.Test;

/**
 * @ClassName: Solution20250211
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/11 14:44
 * @Version: 1.0
 */
public class Solution20250211 {

    @Test
    public void test() {
        System.out.println("1".substring(0, 0));
    }

    public String longestCommonPrefix(String[] strs) {
        int end = 0;
        while (end < 200) {
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() <= end)
                    // 双层循环,这个break跳不出来……
                    return end == 0 ? "" : strs[0].substring(0, end);
                if (i > 0 && strs[i].charAt(end) != strs[0].charAt(end))
                    return strs[0].substring(0, end);
            }
            end++;
        }
        return strs[0].substring(0, end);
    }
}
