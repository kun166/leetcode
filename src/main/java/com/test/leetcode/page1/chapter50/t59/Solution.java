package com.test.leetcode.page1.chapter50.t59;

import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-06 13:58
 */
public class Solution {

    @Test
    public void test() {
        int[][] m = generateMatrix(4);
        for (int[] a : m) {
            System.out.println();
            for (int i : a) {
                System.out.print(i + ",");
            }
        }
    }

    public int[][] generateMatrix(int n) {
        int length = n * n;
        int[][] ans = new int[n][n];
        int direction = 1, c = 1, x = 0, y = 0;
        for (int i = 1; i <= length; i++) {
            ans[y][x] = i;
            if (direction == 1) {
                if (x + c == n) {
                    direction = 2;
                    y++;
                } else {
                    x++;
                }
            } else if (direction == 2) {
                if (y + c == n) {
                    direction = 3;
                    x--;
                } else {
                    y++;
                }
            } else if (direction == 3) {
                if (x == c - 1) {
                    direction = 4;
                    y--;
                } else {
                    x--;
                }
            } else if (direction == 4) {
                if (y == c) {
                    c++;
                    direction = 1;
                    x++;
                } else {
                    y--;
                }
            }
        }
        return ans;
    }
}
