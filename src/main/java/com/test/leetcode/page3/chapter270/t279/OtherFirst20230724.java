package com.test.leetcode.page3.chapter270.t279;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OtherFirst20230724
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/24 08:59
 * @Version: 1.0
 */
public class OtherFirst20230724 {

    int INF = -1;

    /**
     * 执行用时：1366 ms, 在所有 Java 提交中击败了5.00%的用户
     * 内存消耗：52.1 MB, 在所有 Java 提交中击败了5.00%的用户
     * 通过测试用例：588 / 588
     *
     * @param n
     * @return
     */
    public int numSquares(int n) {
        // 预处理出所有可能用到的「完全平方数」
        List<Integer> list = new ArrayList<>();
        int idx = 1;
        while (idx * idx <= n) {
            list.add(idx * idx);
            idx++;
        }

        // f[i][j] 代表考虑前 i 个物品，凑出 j 所使用到的最小元素个数
        int len = list.size();
        int[][] f = new int[len][n + 1];

        // 处理第一个数的情况
        for (int j = 0; j <= n; j++) {
            int t = list.get(0);
            int k = j / t;
            if (k * t == j) { // 只有容量为第一个数的整数倍的才能凑出
                f[0][j] = k;
            } else { // 其余则为无效值
                f[0][j] = INF;
            }
        }

        // 处理剩余数的情况
        for (int i = 1; i < len; i++) {
            int t = list.get(i);
            for (int j = 0; j <= n; j++) {

                // 对于不选第 i 个数的情况
                f[i][j] = f[i - 1][j];

                // 对于选 k 次第 i 个数的情况
                for (int k = 1; k * t <= j; k++) {
                    // 能够选择 k 个 t 的前提是剩余的数字 j - k * t 也能被凑出
                    if (f[i - 1][j - k * t] != INF) {
                        f[i][j] = Math.min(f[i][j], f[i - 1][j - k * t] + k);
                    }
                }

            }
        }
        return f[len - 1][n];
    }
}
