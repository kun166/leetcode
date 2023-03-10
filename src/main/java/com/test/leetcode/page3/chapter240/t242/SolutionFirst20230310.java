package com.test.leetcode.page3.chapter240.t242;

/**
 * @ClassName: Solution20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 16:49
 * @Version: 1.0
 */
public class SolutionFirst20230310 {

    /**
     * 呃，这代码写的我很喜欢，有官方的味道了
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] ss = new int[26];
        int[] tt = new int[26];
        for (char c : s.toCharArray()) {
            ss[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            int index = c - 'a';
            tt[index]++;
            if (tt[index] > ss[index]) {
                return false;
            }
        }
        return true;
    }
}
