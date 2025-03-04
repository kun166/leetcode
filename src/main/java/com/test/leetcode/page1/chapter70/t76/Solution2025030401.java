package com.test.leetcode.page1.chapter70.t76;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution2025030401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/4 08:58
 * @Version: 1.0
 */
public class Solution2025030401 {

    @Test
    public void test() {
        System.out.println(minWindow("ab", "a"));
    }

    /**
     * 先别管进阶了,先搞定这道困难题再说
     *
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) {
            return "";
        }
        // 用26个数组长度感觉代码太复杂,直接用Map吧
        Map<Character, Integer> map = new HashMap<>();
        int minLeft = 0, minRight = m, left = 0, right1 = 0, right2 = 0;
        while (right1 < m) {
            map.put(s.charAt(right1), map.getOrDefault(s.charAt(right1), 0) + 1);
            // map里面存的是right未+1之前的字符
            right1++;

            while (right2 < n && map.getOrDefault(t.charAt(right2), 0) > 0) {
                map.put(t.charAt(right2), map.get(t.charAt(right2)) - 1);
                right2++;
            }

            while (right2 == n && map.get(s.charAt(left)) > 0) {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
                if (right1 - left < minRight - minLeft) {
                    minLeft = left;
                    minRight = right1;
                }
            }
        }
        if (right2 < n)
            return "";
        return s.substring(minLeft, minRight);
    }

}
