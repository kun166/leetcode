package com.test.leetcode.page3.chapter290.t292;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20230403
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/3 16:39
 * @Version: 1.0
 */
public class SolutionFirst20230403 {

    @Test
    public void test() {
        for (int i = 1; i <= 20; i++) {
            System.out.println(i + ":" + canWinNim(i));
        }
        //System.out.println(canWinNim(5));
    }

    /**
     * 呃，超出时间限制了，汗
     *
     * @param n
     * @return
     */
    public boolean canWinNim(int n) {
        if (n <= 3) {
            return true;
        }
        boolean[] dp = new boolean[3];
        Arrays.fill(dp, true);
        for (int i = 3; i < n; i++) {
            boolean win = false;
            for (int j = 1; j <= 3; j++) {
                win = win || !dp[j - 1];
            }
            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = win;
        }
        return dp[2];
    }
}
