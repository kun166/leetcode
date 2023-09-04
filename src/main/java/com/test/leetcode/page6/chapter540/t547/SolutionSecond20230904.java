package com.test.leetcode.page6.chapter540.t547;

/**
 * @ClassName: SolutionSecond20230904
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/9/4 10:39
 * @Version: 1.0
 */
public class SolutionSecond20230904 {

    /**
     * 学习深度优先
     * 1ms
     * 击败 97.70%使用 Java 的用户
     * 44.11MB
     * 击败 5.52%使用 Java 的用户
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visit = new boolean[cities];
        int ans = 0;
        for (int i = 0; i < cities; i++) {
            if (!visit[i]) {
                dfs(isConnected, visit, i);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int[][] isConnected, boolean[] visit, int index) {
        if (visit[index]) {
            return;
        }
        visit[index] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[index][i] == 1) {
                dfs(isConnected, visit, i);
            }
        }
    }
}
