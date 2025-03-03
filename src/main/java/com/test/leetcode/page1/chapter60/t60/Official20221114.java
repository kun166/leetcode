package com.test.leetcode.page1.chapter60.t60;

import java.util.Arrays;

/**
 * @ClassName: Official20221114
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/14 20:11
 * @Version: 1.0
 */
public class Official20221114 {

    public String getPermutation(int n, int k) {
        /**
         * 阶乘,1,2,6,24,120
         * 也即1!,2!,3!,4!,5!
         */
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; ++i) {
            // 呃，这牛逼的地方在于factorial[0]==1,factorial[1]==1
            factorial[i] = factorial[i - 1] * i;
        }
        // 唉唉唉,这……
        --k;
        StringBuffer ans = new StringBuffer();
        int[] valid = new int[n + 1];
        Arrays.fill(valid, 1);
        for (int i = 1; i <= n; ++i) {
            // 遍历n个位置
            int order = k / factorial[n - i] + 1;
            for (int j = 1; j <= n; ++j) {
                order -= valid[j];
                if (order == 0) {
                    ans.append(j);
                    valid[j] = 0;
                    break;
                }
            }
            k %= factorial[n - i];
        }
        return ans.toString();
    }
}
