package com.test.leetcode.page4.chapter370.t375;

import org.junit.Test;

/**
 * @ClassName: Solution20230515
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/15 09:17
 * @Version: 1.0
 */
public class Solution20230515 {

    @Test
    public void test() {
        System.out.println(getMoneyAmount(10));
    }

    /**
     * 看官方解不太好理解
     *
     * @param n
     * @return
     */
    public int getMoneyAmount(int n) {
        // 这个地方为什么要长度要设置n+2?是因为下面的代码中，当i=1,k=i,的时候,f[i][k-1]能不越界
        // 同样的道理，当j=n,k=j的时候，f[k+1][j]也不越界
        // 思考一下，为什么不怕越界？因为越界的地方，默认为0是可以的
        int[][] f = new int[n + 2][n + 2];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                f[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    f[i][j] = Math.min(f[i][j], k + Math.max(f[i][k - 1], f[k + 1][j]));
                }
            }
        }
        return f[1][n];
    }
}
