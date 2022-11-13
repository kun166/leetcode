package com.test.leetcode.page1.chapter50.t54;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Official2022111301
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 11:41
 * @Version: 1.0
 */
public class Official2022111301 {

    /**
     * 模拟
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        // 行数和列数
        int rows = matrix.length, columns = matrix[0].length;
        // 记录坐标是否被访问过
        boolean[][] visited = new boolean[rows][columns];
        // 矩阵总的数量
        int total = rows * columns;
        // 行和列
        int row = 0, column = 0;
        // 方向，这个变量定义的好
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int directionIndex = 0;
        for (int i = 0; i < total; i++) {
            order.add(matrix[row][column]);
            visited[row][column] = true;
            int nextRow = row + directions[directionIndex][0], nextColumn = column + directions[directionIndex][1];
            if (nextRow < 0 || nextRow >= rows || nextColumn < 0 || nextColumn >= columns || visited[nextRow][nextColumn]) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            column += directions[directionIndex][1];
        }
        return order;
    }
}
