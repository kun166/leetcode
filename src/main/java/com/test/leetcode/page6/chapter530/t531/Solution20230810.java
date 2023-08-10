package com.test.leetcode.page6.chapter530.t531;

import org.junit.Test;

/**
 * @ClassName: Solution20230810
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/10 14:43
 * @Version: 1.0
 */
public class Solution20230810 {

    @Test
    public void test() {
        System.out.println(findLonelyPixel(new char[][]{
                {'W', 'B', 'B'},
                {'W', 'B', 'W'},
                {'B', 'W', 'W'}}));
    }

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：44 MB, 在所有 Java 提交中击败了55.11%的用户
     * 通过测试用例：52 / 52
     *
     * @param picture
     * @return
     */
    public int findLonelyPixel(char[][] picture) {
        int m = picture.length, n = picture[0].length;
        boolean[] b = new boolean[n];
        int ans = 0, bCount = 0;
        for (int i = 0; i < m; i++) {
            if (bCount == n) {
                return ans;
            }
            for (int j = 0; j < n; j++) {
                if (!b[j] && picture[i][j] == 'B') {
                    bCount++;
                    b[j] = true;
                    // 检测下方是否有B
                    int k = i + 1;
                    for (; k < m; k++) {
                        if (picture[k][j] == 'B') {
                            break;
                        }
                    }
                    if (k < m) {
                        continue;
                    }
                    // 检测整行是否有B
                    k = 0;
                    for (; k < n; k++) {
                        if (k != j && picture[i][k] == 'B') {
                            break;
                        }
                    }
                    if (k == n) {
                        ans++;
                    }
                    break;
                }
            }
        }
        return ans;
    }
}
