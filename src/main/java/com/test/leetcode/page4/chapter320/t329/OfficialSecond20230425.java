package com.test.leetcode.page4.chapter320.t329;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: OfficialSecond20230425
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/25 09:51
 * @Version: 1.0
 */
public class OfficialSecond20230425 {
    public int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public int rows, columns;

    /**
     * 方法二：拓扑排序
     *
     * @param matrix
     * @return
     */
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        rows = matrix.length;
        columns = matrix[0].length;
        int[][] outdegrees = new int[rows][columns];
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                for (int[] dir : dirs) {
                    int newRow = i + dir[0], newColumn = j + dir[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] > matrix[i][j]) {
                        ++outdegrees[i][j];
                    }
                }
            }
        }
        Queue<int[]> queue = new LinkedList<int[]>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (outdegrees[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            ++ans;
            int size = queue.size();
            for (int i = 0; i < size; ++i) {
                int[] cell = queue.poll();
                int row = cell[0], column = cell[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0], newColumn = column + dir[1];
                    if (newRow >= 0 && newRow < rows && newColumn >= 0 && newColumn < columns && matrix[newRow][newColumn] < matrix[row][column]) {
                        --outdegrees[newRow][newColumn];
                        if (outdegrees[newRow][newColumn] == 0) {
                            queue.offer(new int[]{newRow, newColumn});
                        }
                    }
                }
            }
        }
        return ans;
    }

}
