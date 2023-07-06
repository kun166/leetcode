package com.test.leetcode.page2.chapter120.t120;

import java.util.List;

/**
 * @ClassName: SolutionSecond20230706
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/6 09:19
 * @Version: 1.0
 */
public class SolutionSecond20230706 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] dp = new int[n];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] + triangle.get(i).get(i);
            // 从后向前，否则求后面的数的时候，前面的会被覆盖
            for (int j = i - 1; j > 0; j--) {
                dp[j] = Math.min(dp[j], dp[j - 1]) + triangle.get(i).get(j);
            }
            dp[0] += triangle.get(i).get(0);
        }
        int ans = Integer.MAX_VALUE;
        for (int i : dp) {
            ans = Math.min(ans, i);
        }
        return ans;
    }
}
