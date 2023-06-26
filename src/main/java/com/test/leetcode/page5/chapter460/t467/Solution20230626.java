package com.test.leetcode.page5.chapter460.t467;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20230626
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/26 07:49
 * @Version: 1.0
 */
public class Solution20230626 {

    /**
     * 呃，好吧，我这个解法确实是傻逼啊。解决不了……
     * <p>
     * <p>
     * <p>
     * 字符串中包含两部分：
     * 1、单个字符：只需要关注字符串中的单个字符是否有重复即可
     * 2、多个连续字符。多个连续字符，也需要考虑重复性
     *
     * @param s
     * @return
     */
    public int findSubstringInWraproundString(String s) {
        Set<String> set = new HashSet<>();
        int n = s.length();
        //单个字符
        for (int i = 0; i < n; i++) {
            set.add(s.substring(i, i + 1));
        }
        // 多个连续字符，这个感觉用双指针会好点吧？
        int left = 0, right = 1;
        while (right < n) {
            if ((s.charAt(right) - s.charAt(right - 1) + 26) % 26 == 1) {
                // right位置上的字符串和上一个字符串连续
                right++;
                continue;
            }
            // 不连续了
            if (right - left > 1) {

            }
            left = right;
            right++;
        }
        return set.size();
    }
}
