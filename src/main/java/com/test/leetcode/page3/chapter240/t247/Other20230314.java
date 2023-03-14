package com.test.leetcode.page3.chapter240.t247;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Other20230314
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/14 10:14
 * @Version: 1.0
 */
public class Other20230314 {

    char[][] map = {{'0', '0'}, {'1', '1'}, {'8', '8'}, {'6', '9'}, {'9', '6'}};

    /**
     * 呃，人家这个只用时4秒……
     * <p>
     * 执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：51 MB, 在所有 Java 提交中击败了81.05%的用户
     *
     * @param n
     * @return
     */
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        char[] temp = new char[n];
        backTrack(res, temp, 0, n);
        return res;
    }

    /**
     * 递归回溯
     *
     * @param res   返回值
     * @param cur   char数组
     * @param count 当前char下标吧
     * @param n
     */
    private void backTrack(List<String> res, char[] cur, int count, int n) {
        // 如果n为5，则count为3
        // 如果n为4,则count为2
        if (count > (n - 1) / 2) {
            res.add(new String(cur));
            return;
        }
        if (n % 2 == 1 && count == (n - 1) / 2) {
            // 如果n为奇数，且中间这个元素，只能选0，1，8
            for (int i = 0; i < 3; i++) {
                cur[count] = map[i][0];
                backTrack(res, cur, count + 1, n);
            }
        } else {
            // 避开第一个下标值为0，因为为0不符合要求
            int i = count == 0 ? 1 : 0;
            for (; i < map.length; i++) {
                cur[count] = map[i][0];
                cur[n - 1 - count] = map[i][1];
                backTrack(res, cur, count + 1, n);
            }
        }
    }
}
