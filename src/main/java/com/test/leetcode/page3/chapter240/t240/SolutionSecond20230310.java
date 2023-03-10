package com.test.leetcode.page3.chapter240.t240;

/**
 * @ClassName: SolutionSecond20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 09:05
 * @Version: 1.0
 */
public class SolutionSecond20230310 {

    /**
     * 这种方式是我想到的比较好的方式了，但是好像还是不太行。
     * 6ms,击败39%
     * 莫非要二分？
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int i = 0, j = 0;
        // 表示当前坐标是从哪里来的,1左边,2右边,3上面
        int type = 0;
        while (true) {
            // 存在三种情况，=,<,>
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                // 小于target,要么向右，要么向下
                // 向右。向右的前提是下标不超，且当前坐标不是从右边来的
                if (type != 2 && j < n - 1) {
                    type = 1;
                    j++;
                } else if (i < m - 1) {
                    // 向下
                    type = 3;
                    i++;
                } else {
                    // 不能向右也不能向下
                    return false;
                }
            } else {
                // 当前坐标大于target
                // 向左，或者向下
                // 向左
                if (type != 1 && j > 0) {
                    type = 2;
                    j--;
                } else if (type != 3 && i < m - 1) {
                    // 大于target的时候，不能连续向下
                    type = 3;
                    i++;
                } else {
                    return false;
                }
            }
        }
    }
}
