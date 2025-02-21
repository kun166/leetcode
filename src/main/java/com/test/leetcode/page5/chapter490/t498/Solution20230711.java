package com.test.leetcode.page5.chapter490.t498;

/**
 * @ClassName: Solution20230711
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/11 17:49
 * @Version: 1.0
 */
public class Solution20230711 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：45 MB, 在所有 Java 提交中击败了51.99%的用户
     * 通过测试用例：32 / 32
     *
     * @param mat
     * @return
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int index = 0;
        int[] ans = new int[m * n];
        for (int i = 0; i < m; i++) {
            // 按行遍历
            int start = index;
            // 第一个元素是 x=0,y=i
            int x = 0, y = i;
            while (y >= 0 && x < n) {
                ans[index] = mat[y][x];
                index++;
                y--;
                x++;
            }
            if (i % 2 != 0) {
                // 换位置
                reverse(ans, start, index - 1);
            }
        }
        for (int i = 1; i < n; i++) {
            int start = index;
            // 第一个元素是 x=i,y=m-1
            int x = i, y = m - 1;
            while (y >= 0 && x < n) {
                ans[index] = mat[y][x];
                index++;
                y--;
                x++;
            }
            if ((m + i - 1) % 2 != 0) {
                // 换位置
                reverse(ans, start, index - 1);
            }
        }
        return ans;
    }

    public void reverse(int[] ans, int start, int end) {
        while (start < end) {
            int mid = ans[start];
            ans[start] = ans[end];
            ans[end] = mid;
            start++;
            end--;
        }
    }

}
