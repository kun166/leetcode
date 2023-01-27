package com.test.leetcode.page2.chapter120.t120;

import java.util.List;

/**
 * @ClassName: OfficialThird20230127
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/27 10:11
 * @Version: 1.0
 */
public class OfficialThird20230127 {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        // 这个地方用的比较好
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
}
