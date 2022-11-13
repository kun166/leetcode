package com.test.leetcode.page1.chapter50.t54;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: LastPoint20221112
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/12 19:10
 * @Version: 1.0
 */
public class LastPoint20221112 {

    @Test
    public void test() {
        int m = 4;
        int n = 4;
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                list.add(i * n + j);
            }
            matrix.add(list);
        }
        System.out.println(JSON.toJSONString(matrix));
        int[] position = findLastPoint(m, n);
        System.out.println(JSON.toJSONString(position));
        System.out.println(matrix.get(position[0]).get(position[1]));
    }

    /**
     * m行n列的矩阵，按顺时针方向转圈，返回最后一个点的坐标
     *
     * @param m 行
     * @param n 列
     * @return
     */
    public int[] findLastPoint(int m, int n) {
        // 行数小于列数
        boolean row = m < n;
        // 行数小于列数，则行数是否是奇数，否则列数是不是奇数
        boolean odd = row ? (m % 2 == 1) : (n % 2 == 1);
        // 圈数
        int half = row ? (odd ? m / 2 + 1 : m / 2) : (odd ? n / 2 + 1 : n / 2);
        if (row) {
            if (odd) {
                return new int[]{half - 1, n - half};
            }
            return new int[]{half, half - 1};
        } else {
            if (odd) {
                return new int[]{m - half, half - 1};
            }
            return new int[]{half, half - 1};
        }
    }
}
