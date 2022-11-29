package com.test.leetcode.page1.chapter70.t74;

/**
 * 两次二分查找
 *
 * @ClassName: Official20221128First
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/28 20:53
 * @Version: 1.0
 */
public class Official20221128First {

    /**
     * 两次二分查找
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowIndex = binarySearchFirstColumn(matrix, target);
        if (rowIndex < 0) {
            return false;
        }
        return binarySearchRow(matrix[rowIndex], target);
    }

    /**
     * 这个是返回行数
     *
     * @param matrix
     * @param target
     * @return
     */
    public int binarySearchFirstColumn(int[][] matrix, int target) {
        int low = -1, high = matrix.length - 1;
        while (low < high) {
            // 这个mid向high靠齐,确实运用的巧妙
            int mid = (high - low + 1) / 2 + low;
            if (matrix[mid][0] <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public boolean binarySearchRow(int[] row, int target) {
        int low = 0, high = row.length - 1;
        // <=能保证，low==high的时候，也能执行一次
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (row[mid] == target) {
                return true;
            } else if (row[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
}
