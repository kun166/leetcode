package com.test.leetcode.page3.chapter200.t200;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: OfficialSecond20230217
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/17 10:25
 * @Version: 1.0
 */
public class OfficialSecond20230217 {

    /**
     * 广度优先
     *
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        //行
        int nr = grid.length;
        // 列
        int nc = grid[0].length;
        // 陆地数量
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            // 先遍历行
            for (int c = 0; c < nc; ++c) {
                // 再遍历列
                if (grid[r][c] == '1') {
                    // 当前坐标如果为'1',则陆地+1
                    ++num_islands;
                    // 当前坐标置为0，已经累加过了
                    grid[r][c] = '0';
                    // 这个应该是记录的累加过的陆地的坐标?将x,y换算成了x*nc+y
                    // 嗯哼，思考下这个问题，二维数组下标的两个值能用一个值替代么？答案是可以啊，这就是
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        // 一个数值标识的二维下标，换算成真实的二维下标
                        int row = id / nc;
                        int col = id % nc;
                        // 下面这些，我怎么感觉也是深度优先呢？
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }

}
