package com.test.leetcode.page1.chapter50.t59;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution20221113
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/13 20:12
 * @Version: 1.0
 */
public class Solution20221113 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(generateMatrix(1)));
    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        int number = 1;
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = number++;
            }
            for (int i = top + 1; i <= bottom; i++) {
                ans[i][right] = number++;
            }
            if (top < bottom && left < right) {
                for (int i = right - 1; i >= left; i--) {
                    ans[bottom][i] = number++;
                }
                for (int i = bottom - 1; i > top; i--) {
                    ans[i][left] = number++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return ans;
    }
}
