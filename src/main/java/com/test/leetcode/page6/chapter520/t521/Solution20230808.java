package com.test.leetcode.page6.chapter520.t521;

/**
 * @ClassName: Solution20230808
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/8 16:48
 * @Version: 1.0
 */
public class Solution20230808 {

    public int findLUSlength(String a, String b) {
        int max = -1;
        boolean[] ba = new boolean[26];
        boolean[] bb = new boolean[26];
        // 先遍历a
        for (char c : a.toCharArray()) {
            ba[c - 'a'] = true;
        }
        // 寻找b的最长字符串
        int maxB = 0;
        for (char c : b.toCharArray()) {
            bb[c - 'a'] = true;
            if (ba[c - 'a']) {
                // 说明在a中有了
                if (maxB != 0) {
                    max = Math.max(max, maxB);
                }
                maxB = 0;
            } else {
                maxB++;
            }
        }
        if (maxB != 0) {
            max = Math.max(max, maxB);
        }
        // 寻找a中的最长字符串
        int maxA = 0;
        for (char c : a.toCharArray()) {
            if (bb[c - 'a']) {
                // 说明在b中有了
                if (maxA != 0) {
                    max = Math.max(max, maxA);
                }
                maxA = 0;
            } else {
                maxA++;
            }
        }
        if (maxA != 0) {
            max = Math.max(max, maxA);
        }
        return max;
    }
}
