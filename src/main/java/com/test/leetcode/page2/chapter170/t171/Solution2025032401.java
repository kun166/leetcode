package com.test.leetcode.page2.chapter170.t171;

/**
 * @ClassName: Solution2025032401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/24 15:02
 * @Version: 1.0
 */
public class Solution2025032401 {


    /**
     * 1ms	击败51.32%
     * 41.29MB	击败93.19%
     *
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int ans = 0;
        for (char c : columnTitle.toCharArray()) {
            ans = ans * 26 + (c - 'A' + 1);
        }
        return ans;
    }
}
