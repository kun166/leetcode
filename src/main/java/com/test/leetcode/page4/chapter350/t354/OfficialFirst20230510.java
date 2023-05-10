package com.test.leetcode.page4.chapter350.t354;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: OfficialFirst20230510
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/10 10:34
 * @Version: 1.0
 */
public class OfficialFirst20230510 {

    /**
     * 方法一：动态规划
     * 这个题的解释，官方已经写好了，如果想了解，可以仔细看一下
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length == 0) {
            return 0;
        }

        int n = envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] e1, int[] e2) {
                if (e1[0] != e2[0]) {
                    //  先按第一个元素进行升序排列
                    return e1[0] - e2[0];
                } else {
                    // 按第二个元素降序排列
                    return e2[1] - e1[1];
                }
            }
        });

        // 下面的题解，和300题的题解一样了
        int[] f = new int[n];
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                if (envelopes[j][1] < envelopes[i][1]) {
                    f[i] = Math.max(f[i], f[j] + 1);
                }
            }
            ans = Math.max(ans, f[i]);
        }
        return ans;
    }
}
