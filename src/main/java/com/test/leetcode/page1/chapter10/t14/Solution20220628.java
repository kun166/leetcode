package com.test.leetcode.page1.chapter10.t14;

import org.junit.Test;

/**
 * @ClassName: Solution20220628
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/28 10:55
 * @Version: 1.0
 */
public class Solution20220628 {

    @Test
    public void test() {
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int index = -1;
        while (true) {
            for (int i = 0; i < strs.length; i++) {
                if (index >= strs[i].length() - 1) {
                    if (index == -1) {
                        return "";
                    }
                    return strs[0].substring(0, index + 1);
                }
                if (i > 0) {
                    if (strs[i].charAt(index + 1) != strs[0].charAt(index + 1)) {
                        if (index == -1) {
                            return "";
                        }
                        return strs[0].substring(0, index + 1);
                    }
                }
            }
            index++;
        }
    }
}
