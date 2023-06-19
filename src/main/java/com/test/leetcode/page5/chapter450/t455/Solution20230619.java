package com.test.leetcode.page5.chapter450.t455;

import java.util.Arrays;

/**
 * @ClassName: Solution20230619
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/19 07:23
 * @Version: 1.0
 */
public class Solution20230619 {

    /**
     * 执行用时：7 ms, 在所有 Java 提交中击败了99.92%的用户
     * 内存消耗：42.9 MB, 在所有 Java 提交中击败了35.91%的用户
     * 通过测试用例：21 / 21
     *
     * @param g
     * @param s
     * @return
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int left = g.length - 1, right = s.length - 1;
        while (left >= 0) {
            if (right < 0) {
                break;
            }
            if (g[left] <= s[right]) {
                right--;
                ans++;
            }
            left--;
        }
        return ans;
    }
}
