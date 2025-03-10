package com.test.leetcode.page1.chapter90.t96;

/**
 * @ClassName: Solution2025031001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/10 09:13
 * @Version: 1.0
 */
public class Solution2025031001 {

    /**
     * 呃，好吧，超出时间限制……
     *
     * @param n
     * @return
     */
    public int numTrees(int n) {
        return numTrees(1, n);
    }

    public int numTrees(int left, int right) {
        if (left >= right) {
            return 1;
        }

        int ans = 0;
        for (int index = left; index <= right; index++) {
            int l = numTrees(left, index - 1);
            int r = numTrees(index + 1, right);
            ans += l * r;
        }
        return ans;
    }
}
