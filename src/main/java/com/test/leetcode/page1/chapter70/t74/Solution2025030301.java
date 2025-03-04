package com.test.leetcode.page1.chapter70.t74;

/**
 * @ClassName: Solution2025030301
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/3 10:13
 * @Version: 1.0
 */
public class Solution2025030301 {

    /**
     * 呃，先按列1二分，再按找到的行二分？
     * <p>
     * [[1,3]]
     * 3
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        // 先来个速算吧?
        if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
            return false;
        }
        // 第一列二分
        int top = 0, bottom = m - 1;
        while (top < bottom) {
            int mid = (top + bottom) >> 1;
            if (mid == top) {
                // 防止死循环
                break;
            }
            if (matrix[mid][0] == target) {
                return true;
            } else if (matrix[mid][0] > target) {
                bottom = mid;
            } else {
                top = mid;
            }
        }
        // 加一个判断吧，感觉容易出问题
        top = matrix[bottom][0] > target ? top : bottom;
        // 在top这行二分查找
        int left = 0, right = n - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (left == mid) {
                /**
                 * 这个地方第一次提交做错了，汗，需要注意
                 */
                return matrix[top][left] == target || matrix[top][right] == target;
            }
            if (matrix[top][mid] == target) {
                return true;
            } else if (matrix[top][mid] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return false;
    }

}
