package com.test.leetcode.page1.chapter0.t3;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: SolutionSecond20221019
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/19 11:17
 * @Version: 1.0
 */
public class SolutionSecond20221019 {

    public int lengthOfLongestSubstring(String s) {
        int l = 0, r = 0, max = 0;
        Set<Character> set = new HashSet<>();
        char[] array = s.toCharArray();
        for (; r < s.length(); r++) {
            while (set.contains(array[r])) {
                set.remove(array[l++]);
            }
            set.add(array[r]);
            max = Math.max(max, set.size());
        }
        return max;
    }
}
