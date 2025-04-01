package com.test.leetcode.page3.chapter220.t221;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @ClassName: Solution2025040103
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 11:18
 * @Version: 1.0
 */
public class Solution2025040103 {

    @Test
    public void test() {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        };
        System.out.println(maximalSquare(matrix));
    }

    /**
     * 呃,看了2023年的解答,感觉自己当时很牛啊,想的解法,这次居然没想到……
     * 可以参考84题……
     * <p>
     * 18ms	击败12.69%
     * 57.14MB	击败88.21%
     *
     * @param matrix
     * @return
     */
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length, wide = 0;
        // 按每一行计算,申请列数个数组,记录每一列的1的个数
        int[] array = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    array[j] = i == 0 ? 1 : array[j] + 1;
                } else {
                    array[j] = 0;
                }
            }
            wide = Math.max(wide, findMaxWide(array));
        }
        return wide * wide;
    }

    int findMaxWide(int[] array) {
        int wide = 0, n = array.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);
        LinkedList<Integer> ll = new LinkedList<>();
        ll.push(-1);
        for (int i = 0; i < n; i++) {
            while (ll.peek() != -1 && array[ll.peek()] >= array[i]) {
                right[ll.pop()] = i;
            }
            left[i] = ll.peek();
            ll.push(i);
        }
        for (int i = 0; i < n; i++) {
            wide = Math.max(wide, Math.min(array[i], right[i] - left[i] - 1));
        }
        return wide;
    }
}
