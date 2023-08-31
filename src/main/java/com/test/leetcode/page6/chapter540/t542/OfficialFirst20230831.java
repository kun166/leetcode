package com.test.leetcode.page6.chapter540.t542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: OfficialFirst20230831
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/31 09:29
 * @Version: 1.0
 */
public class OfficialFirst20230831 {

    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 广度优先
     * 13ms
     * 击败 51.69%使用 Java 的用户
     * 43.75MB
     * 击败 48.89%使用 Java 的用户
     *
     * @param matrix
     * @return
     */
    public int[][] updateMatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] dist = new int[m][n];
        boolean[][] seen = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<int[]>();
        // 将所有的 0 添加进初始队列中
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    seen[i][j] = true;
                }
            }
        }

        // 广度优先搜索
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];
            for (int d = 0; d < 4; ++d) {
                int ni = i + dirs[d][0];
                int nj = j + dirs[d][1];
                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !seen[ni][nj]) {
                    dist[ni][nj] = dist[i][j] + 1;
                    // 呃，这个算法牛逼的地方在这里，先从距离为1的开始找，再从距离为2的找，依次类推……
                    queue.offer(new int[]{ni, nj});
                    seen[ni][nj] = true;
                }
            }
        }

        return dist;
    }
}
