package com.test.leetcode.page1.chapter0.t3;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-10 14:38
 */
public class Solution {

    @Test
    public void test() {
        //System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("abcbad"));
    }


    public int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 左指针，初始值为 -1。同时下面的i是右指针
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            // 最外层这个循环，是为了删除重复字符的，就是为了rk
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符。直到把重复的那个字符删除了为止
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 这一层循环才是为了找出最大长度的
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }
}
