package com.test.leetcode.page1.chapter0.t3;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Solution20220621
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/21 09:44
 * @Version: 1.0
 */
public class Solution20220621 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int maxL = 0;
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (set.contains(c)) {
                maxL = Math.max(maxL, right - left);
                while (set.contains(c)) {
                    set.remove(s.charAt(left));
                    left++;
                }
            }
            set.add(c);
            right++;
        }
        maxL = Math.max(maxL, right - left);
        return maxL;
    }
}
