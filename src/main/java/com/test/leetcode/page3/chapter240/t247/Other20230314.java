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

    private void backTrack(List<String> res, char[] cur, int count, int n) {
        if (count > (n - 1) / 2) {
            res.add(new String(cur));
            return;
        }
        if (n % 2 == 1 && count == (n - 1) / 2) {
            for (int i = 0; i < 3; i++) {
                cur[count] = map[i][0];
                backTrack(res, cur, count + 1, n);
            }
        } else {
            int i = count == 0 ? 1 : 0;
            for (; i < map.length; i++) {
                cur[count] = map[i][0];
                cur[n - 1 - count] = map[i][1];
                backTrack(res, cur, count + 1, n);
            }
        }
    }
}
