package com.test.leetcode.page6.chapter540.t547;

import org.junit.Test;

/**
 * @ClassName: SolutionSecond20230901
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/9/1 14:21
 * @Version: 1.0
 */
public class SolutionSecond20230901 {

    @Test
    public void test() {

        int[][] array = new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        System.out.println(findCircleNum(array));
    }

    /**
     * 查并集，一定要学会啊
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        // 定义父节点
        int[] parent = new int[cities];
        // 初始化父节点,开始每个点的父节点都是自己
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

    public void union(int[] parent, int p1, int p2) {
        parent[findParent(parent, p1)] = findParent(parent, p2);
    }

    public int findParent(int[] parent, int p) {
        if (parent[p] != p) {
            parent[p] = findParent(parent, parent[p]);
        }
        return parent[p];
    }
}
