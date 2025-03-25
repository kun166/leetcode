package com.test.leetcode.page2.chapter170.t174;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution2025032401
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/24 16:33
 * @Version: 1.0
 */
public class Solution2025032402 {

    int ans = Integer.MAX_VALUE;
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 递归-回溯?
     * 呃,好吧,超出时间限制……
     *
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        // 先从结束的地方向前推算,需要的最少血量点数
        backtrack(dungeon, 0, 0, 1, 1);
        return ans;
    }

    public void backtrack(int[][] dungeon, int row, int column, int need, int curBlood) {
        curBlood += dungeon[row][column];
        if (curBlood < 1) {
            need += 1 - curBlood;
            curBlood = 1;
        }

        // 退出条件通过下面来吧
        // 向下
        if (row < dungeon.length - 1) {
            backtrack(dungeon, row + 1, column, need, curBlood);
        }
        // 向左
        if (column < dungeon[0].length - 1) {
            backtrack(dungeon, row, column + 1, need, curBlood);
        }
        if (row == dungeon.length - 1 && column == dungeon[0].length - 1) {
            ans = Math.min(ans, need);
        }
    }
}
