package com.test.leetcode.page3.chapter240.t240;

/**
 * @ClassName: OfficialThird20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 10:18
 * @Version: 1.0
 */
public class OfficialThird20230310 {

    /**
     * 方法三：Z 字形查找
     * <p>
     * 呃，这个方法很妙啊
     * <p>
     * 5ms,击败97.76
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int x = 0, y = n - 1;
        while (x < m && y >= 0) {
            if (matrix[x][y] == target) {
                return true;
            }
            if (matrix[x][y] > target) {
                --y;
            } else {
                /**
                 * 讲一下这个地方为什么成立
                 * matrix[x][y] < target,有两种情况
                 * 1,matrix[x][y]由matrix[x][y+1]>target而来，则需要++x
                 * 2,matrix[x][y]由matrix[x-1][y]<target而来。
                 * 而matrix[x-1][y+1]>target,matrix[x][y+1]>matrix[x-1][y+1],也必然大于target
                 */
                ++x;
            }
        }
        return false;
    }

}
