package com.test.leetcode.page3.chapter240.t242;

/**
 * @ClassName: SolutionSecond20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 16:58
 * @Version: 1.0
 */
public class SolutionSecond20230310 {

    /**
     * 这算法居然比first耗时多，且内存也多？搞笑哈
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] cs = new int[26];
        for (char c : s.toCharArray()) {
            cs[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            if (--cs[index] < 0) {
                return false;
            }
        }
        return true;
    }
}
