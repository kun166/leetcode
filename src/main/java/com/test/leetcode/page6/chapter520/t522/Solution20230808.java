package com.test.leetcode.page6.chapter520.t522;

import org.junit.Test;

/**
 * @ClassName: Solution20230808
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/8 17:12
 * @Version: 1.0
 */
public class Solution20230808 {

    @Test
    public void test() {
        System.out.println(findLUSlength(new String[]{"aaa", "aaa", "aa"}));
    }

    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            boolean equal = false;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (strs[i].equals(strs[j]) || strs[j].indexOf(strs[i]) > -1) {
                    equal = true;
                    break;
                }
            }
            if (!equal) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }
}
