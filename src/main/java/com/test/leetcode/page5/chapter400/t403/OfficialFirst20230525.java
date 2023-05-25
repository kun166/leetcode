package com.test.leetcode.page5.chapter400.t403;

import java.util.Arrays;

/**
 * @ClassName: OfficialFirst20230525
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/25 08:43
 * @Version: 1.0
 */
public class OfficialFirst20230525 {

    // 记忆搜索，rec[i][k]表示当前坐标i，上一次跳跃的距离为k,能否到达最后一块石头
    private Boolean[][] rec;

    public boolean canCross(int[] stones) {
        int n = stones.length;
        rec = new Boolean[n][n];
        return dfs(stones, 0, 0);
    }

    /**
     * 判断从当前位置i，能否跳到最后一块石头
     *
     * @param stones  石头序列
     * @param i       当前所在的石头编号
     * @param lastDis 上一次跳跃的距离
     * @return
     */
    private boolean dfs(int[] stones, int i, int lastDis) {
        if (i == stones.length - 1) {
            // 已经到达最后一块石头，结束
            return true;
        }
        if (rec[i][lastDis] != null) {
            return rec[i][lastDis];
        }

        for (int curDis = lastDis - 1; curDis <= lastDis + 1; curDis++) {
            if (curDis > 0) {
                int j = Arrays.binarySearch(stones, i + 1, stones.length, curDis + stones[i]);
                if (j >= 0 && dfs(stones, j, curDis)) {
                    return rec[i][lastDis] = true;
                }
            }
        }
        return rec[i][lastDis] = false;
    }
}
