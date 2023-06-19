package com.test.leetcode.page5.chapter450.t453;

/**
 * @ClassName: Solution20230615
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/15 09:40
 * @Version: 1.0
 */
public class Solution20230615 {

    /**
     * 好吧，正向解，确实搞不定啊，看了答案确实是真的牛逼。
     * n-1个数+1,反过来就和n-1个数不动，剩余的那个数-1,效果是一样的……
     * <p>
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.9 MB, 在所有 Java 提交中击败了18.02%的用户
     * 通过测试用例：84 / 84
     *
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            min = Math.min(min, i);
        }
        int ans = 0;
        for (int i : nums) {
            ans += i - min;
        }
        return ans;
    }
}
