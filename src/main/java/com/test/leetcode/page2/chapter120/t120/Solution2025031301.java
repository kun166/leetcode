package com.test.leetcode.page2.chapter120.t120;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20250313
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/13 08:57
 * @Version: 1.0
 */
public class Solution2025031301 {

    /**
     * 像这种题，感觉只能dp？
     * <p>
     * 2ms  击败94.25%
     * 42.50MB  击败93.31%
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.get(triangle.size() - 1).size()];
        Arrays.fill(dp, 100000);
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> list = triangle.get(i);
            for (int j = list.size() - 1; j >= 0; j--) {
                // 上一步到下一步,只能移动到i和i+1
                // 那下一步只能由上一步的i和i-1而来
                if (j == 0)
                    dp[j] += list.get(0);
                else {
                    /**
                     * 第一次运行居然没对,下面公式写成了
                     * dp[j] += Math.min(list.get(j), list.get(j-1));
                     */
                    dp[j] = Math.min(dp[j], dp[j - 1]) + list.get(j);
                }
            }
        }
        int ans = dp[0];
        for (int i = 1; i < dp.length; i++) {
            ans = Math.min(ans, dp[i]);
        }
        return ans;
    }
}
