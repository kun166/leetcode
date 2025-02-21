package com.test.leetcode.page6.chapter540.t547;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: OfficialFirst20230901
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/9/1 10:47
 * @Version: 1.0
 */
public class OfficialSecond20230901 {

    /**
     * 广度优先
     *
     * @param isConnected
     * @return
     */
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        boolean[] visited = new boolean[cities];
        int provinces = 0;
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < cities; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    int j = queue.poll();
                    visited[j] = true;
                    for (int k = 0; k < cities; k++) {
                        if (isConnected[j][k] == 1 && !visited[k]) {
                            queue.offer(k);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }


}
