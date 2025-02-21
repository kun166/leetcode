package com.test.leetcode.page6.chapter540.t547;

/**
 * @ClassName: Solution20230904
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/9/4 09:58
 * @Version: 1.0
 */
public class Solution20230904 {


    /**
     * 学习并查集
     * <p>
     * 1ms
     * 击败 97.70%使用 Java 的用户
     * 43.91MB
     * 击败 30.83%使用 Java 的用户
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int[] parent = new int[cities];
        // 初始化，每个城市的父城市都是自己
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < cities; i++) {
            for (int j = 0; j < i; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {
                ans++;
            }
        }
        return ans;
    }

    /**
     * 并
     *
     * @param parent
     * @param p1
     * @param p2
     */
    public void union(int[] parent, int p1, int p2) {
        if (findParent(parent, p1) != findParent(parent, p2)) {
            parent[findParent(parent, p1)] = findParent(parent, p2);
        }
    }

    /**
     * 查
     *
     * @param parent
     * @param p
     * @return
     */
    public int findParent(int[] parent, int p) {
        if (parent[p] != p) {
            parent[p] = findParent(parent, parent[p]);
        }
        return parent[p];
    }
}
