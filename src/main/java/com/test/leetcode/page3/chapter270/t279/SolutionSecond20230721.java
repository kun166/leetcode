package com.test.leetcode.page3.chapter270.t279;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: SolutionSecond20230721
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/21 11:11
 * @Version: 1.0
 */
public class SolutionSecond20230721 {

    int INF = -1;

    @Test
    public void test() {
        System.out.println(numSquares(12));
    }

    /**
     * 呃，超出时间限制……
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1, j; (j = i * i) <= n; i++) {
            list.add(j);
        }
        int m = list.size();
        int[][] dp = new int[m + 1][n + 1];
        Arrays.fill(dp[0], 100000);
        dp[0][0] = 0;
        for (int i = 1; i <= m; i++) {
            int number = list.get(i - 1);
            for (int j = 0; j <= n; j++) {
                dp[i][j] = dp[i - 1][j];
                int count = j / number;
                for (int k = 1; k <= count; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - number * k] + k);
                }
            }
        }
        return dp[m][n];
    }
}
