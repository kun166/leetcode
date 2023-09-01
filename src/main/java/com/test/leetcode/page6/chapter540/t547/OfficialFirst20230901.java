package com.test.leetcode.page6.chapter540.t547;

/**
 * @ClassName: OfficialFirst20230901
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/9/1 10:47
 * @Version: 1.0
 */
public class OfficialFirst20230901 {

    /**
     * 方法一：深度优先搜索
     * 牛逼啊，神一样
     * <p>
     * 1ms
     * 击败 97.43%使用 Java 的用户
     * 43.91MB
     * 击败 29.71%使用 Java 的用户
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        // 所有的城市数量
        int cities = isConnected.length;
        // 该城市是否访问过
        boolean[] visited = new boolean[cities];
        // 省份数量
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            // 循环遍历城市
            if (!visited[i]) {
                // 如果该城市未遍历过，就遍历该城市
                dfs(isConnected, visited, cities, i);
                provinces++;
            }
        }
        return provinces;
    }


    /**
     * 寻找第i个城市联通的城市
     *
     * @param isConnected
     * @param visited     该城市是否访问过。防止死循环
     * @param cities      总的城市数
     * @param i           第i个城市
     */
    public void dfs(int[][] isConnected, boolean[] visited, int cities, int i) {
        for (int j = 0; j < cities; j++) {
            // 遍历第i个城市与其它城市的联通关系
            if (isConnected[i][j] == 1 && !visited[j]) {
                // 如果联通，就设置为第j个城市访问过，且继续以第j个城市寻找联通城市
                visited[j] = true;
                dfs(isConnected, visited, cities, j);
            }
        }
    }

}
