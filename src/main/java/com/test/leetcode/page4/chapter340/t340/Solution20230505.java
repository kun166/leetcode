package com.test.leetcode.page4.chapter340.t340;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20230505
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/5 14:34
 * @Version: 1.0
 */
public class Solution20230505 {

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了79.72%的用户
     * 内存消耗：42.6 MB, 在所有 Java 提交中击败了5.20%的用户
     * 通过测试用例：142 / 142
     *
     * @param s
     * @param k
     * @return
     */
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (k == 0) {
            return 0;
        }
        int ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            while (map.size() > k) {
                char leftC = s.charAt(left);
                int count = map.get(leftC);
                if (count == 1) {
                    map.remove(leftC);
                } else {
                    map.put(leftC, count - 1);
                }
                left++;
            }
            right++;
            ans = Math.max(ans, right - left);

        }
        return ans;
    }
}
