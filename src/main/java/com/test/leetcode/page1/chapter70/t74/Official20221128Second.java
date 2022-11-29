package com.test.leetcode.page1.chapter70.t74;

/**
 * @ClassName: Official20221128Second
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/28 20:59
 * @Version: 1.0
 */
public class Official20221128Second {

    /**
     * 一次二分查找
     * 两种方法殊途同归，都利用了二分查找，在二维矩阵上寻找目标值。
     * 值得注意的是，若二维数组中的一维数组的元素个数不一，方法二将会失效，
     * 而方法一则能正确处理。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int low = 0, high = m * n - 1;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            int x = matrix[mid / n][mid % n];
            if (x < target) {
                low = mid + 1;
            } else if (x > target) {
                high = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
