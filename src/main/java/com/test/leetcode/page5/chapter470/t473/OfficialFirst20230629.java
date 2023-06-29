package com.test.leetcode.page5.chapter470.t473;

import java.util.Arrays;

/**
 * @ClassName: OfficialFirst20230629
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/29 15:18
 * @Version: 1.0
 */
public class OfficialFirst20230629 {

    /**
     * 方法一：回溯
     *
     * @param matchsticks
     * @return
     */
    public boolean makesquare(int[] matchsticks) {
        // 求周长
        int totalLen = Arrays.stream(matchsticks).sum();
        if (totalLen % 4 != 0) {
            // 周长非4的倍数，则不能组成正方形
            return false;
        }
        // 排序
        Arrays.sort(matchsticks);
        // 下面这个逻辑是：上面的排序是从小到大，再给对调一下位置，变成从大到小
        for (int i = 0, j = matchsticks.length - 1; i < j; i++, j--) {
            int temp = matchsticks[i];
            matchsticks[i] = matchsticks[j];
            matchsticks[j] = temp;
        }

        // 四条边
        int[] edges = new int[4];
        return dfs(0, matchsticks, edges, totalLen / 4);
    }

    /**
     * 火柴数组能否组成边长为len的正方形
     *
     * @param index       位置
     * @param matchsticks 火柴数组
     * @param edges       四条边
     * @param len         正方形的边长
     * @return
     */
    public boolean dfs(int index, int[] matchsticks, int[] edges, int len) {
        if (index == matchsticks.length) {
            // 说明所有火柴已经分配结束
            return true;
        }
        for (int i = 0; i < edges.length; i++) {
            edges[i] += matchsticks[index];
            if (edges[i] <= len && dfs(index + 1, matchsticks, edges, len)) {
                return true;
            }
            edges[i] -= matchsticks[index];
        }
        return false;
    }
}
