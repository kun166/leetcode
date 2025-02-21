package com.test.leetcode.page2.chapter120.t120;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20230706
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/6 08:55
 * @Version: 1.0
 */
public class Solution20230706 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            // 从后向前，否则求后面的数的时候，前面的会被覆盖
            for (int j = i; j >= 0; j--) {
                if (i == 0) {
                    dp[j] = triangle.get(i).get(j);
                } else if (j == 0) {
                    dp[j] += triangle.get(i).get(j);
                } else if (i == j) {
                    dp[j] = dp[j - 1] + triangle.get(i).get(j);
                } else {
                    dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i : dp) {
            ans = Math.min(ans, i);
        }
        return ans;
    }
}
