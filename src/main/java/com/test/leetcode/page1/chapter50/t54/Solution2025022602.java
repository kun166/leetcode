package com.test.leetcode.page1.chapter50.t54;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025022602
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/26 09:56
 * @Version: 1.0
 */
public class Solution2025022602 {

    @Test
    public void test() {
        int[][] matrix = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16},
                {17, 18, 19, 20},
                {21, 22, 23, 24}
        };
        System.out.println(JSON.toJSONString(spiralOrder(matrix)));
    }

    /**
     * 太容易疏忽，容易错
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        // 总的循环次数
        int length = matrix.length * matrix[0].length;
        List<Integer> list = new ArrayList<>();
        // 循环的圈数
        int cyclic = 0;
        while (length > list.size()) {
            // 从上左到上右
            for (int i = 0; i < matrix[0].length - cyclic * 2 && length > list.size(); i++) {
                list.add(matrix[cyclic][cyclic + i]);
            }
            // 从右上到右下
            for (int i = 0; i < matrix.length - cyclic * 2 - 1 && length > list.size(); i++) {
                list.add(matrix[cyclic + 1 + i][matrix[0].length - 1 - cyclic]);
            }
            // 从下右到下左
            for (int i = 0; i < matrix[0].length - cyclic * 2 - 1 && length > list.size(); i++) {
                list.add(matrix[matrix.length - 1 - cyclic][matrix[0].length - cyclic - 2 - i]);
            }
            // 从左下到左上
            for (int i = 0; i < matrix.length - cyclic * 2 - 2 && length > list.size(); i++) {
                list.add(matrix[matrix.length - cyclic - 2 - i][cyclic]);
            }
            cyclic++;
        }
        return list;
    }
}
