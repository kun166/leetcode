package com.test.leetcode.page1.chapter0.t3;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20250207
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/7 15:18
 * @Version: 1.0
 */
public class Solution20250207 {

    @Test
    public void test() {

    }

    /**
     * 双指针？
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        int left = 0, max = 1;
        Set<Character> set = new HashSet<>();
        set.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (!set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                max = max > set.size() ? max : set.size();
                continue;
            }
            for (int j = left; j < i; j++) {
                if (s.charAt(j) == s.charAt(i)) {
                    left = j + 1;
                    break;
                }
                set.remove(s.charAt(j));
            }
        }
        return max;
    }
}
