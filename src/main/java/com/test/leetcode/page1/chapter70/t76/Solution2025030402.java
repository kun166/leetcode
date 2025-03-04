package com.test.leetcode.page1.chapter70.t76;

import org.junit.Test;

/**
 * @ClassName: Solution2025030402
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/4 18:58
 * @Version: 1.0
 */
public class Solution2025030402 {

    @Test
    public void test() {
        System.out.println(minWindow("cgklivwehljxrdzpfdqsapogwvjtvbzahjnsejwnuhmomlfsrvmrnczjzjevkdvroiluthhpqtffhlzyglrvorgnalk", "mqfff"));
    }


    /**
     * 2ms 击败100.00%
     * 43.71MB 击败94.84%
     * 呃，有点厉害
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
        int[] array = new int['z' - 'A' + 1];
        int minLeft = 0, minRight = m, left = 0, sRight = 0, tRight = 0;
        while (sRight < m) {
            array[s.charAt(sRight++) - 'A']++;
            while (tRight < n && array[t.charAt(tRight) - 'A'] > 0) {
                array[t.charAt(tRight++) - 'A']--;
            }
            if (tRight == n) {
                while (array[s.charAt(left) - 'A'] > 0) {
                    array[s.charAt(left++) - 'A']--;
                }
                if (sRight - left < minRight - minLeft) {
                    minLeft = left;
                    minRight = sRight;
                }
            }
        }
        if (tRight != n)
            return "";
        return s.substring(minLeft, minRight);
    }
}
