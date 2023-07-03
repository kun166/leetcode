package com.test.leetcode.page5.chapter480.t486;

import org.junit.Test;

/**
 * @ClassName: Solution20230703
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/3 15:11
 * @Version: 1.0
 */
public class SolutionFirst20230703 {

    @Test
    public void test() {
        System.out.println(PredictTheWinner(new int[]{1, 5, 2}));
    }

    /**
     * 递归回溯？
     * <p>
     * 执行用时：2 ms, 在所有 Java 提交中击败了35.48%的用户
     * 内存消耗：39 MB, 在所有 Java 提交中击败了30.59%的用户
     * 通过测试用例：62 / 62
     *
     * @param nums
     * @return
     */
    public boolean PredictTheWinner(int[] nums) {
        return PredictTheWinner(nums, 0, 0, 0, nums.length - 1, 0);
    }

    /**
     * @param nums   可选的数组
     * @param score1 第一个人的分数
     * @param score2 第二个人的分数
     * @param left   可选的左侧下标
     * @param right  可选的右侧下标
     * @param pick   选择的次数
     * @return
     */
    public boolean PredictTheWinner(int[] nums, int score1, int score2, int left, int right, int pick) {
        // 递归回溯的终结
        // 注意递归回溯的终结是left>right，因为当left==right的时候，还有一轮left或者right还没选
        if (left > right) {
            return pick % 2 == 0 ? score1 >= score2 : score1 < score2;
        }
        boolean win = false;
        // 只能拿left或者right的数……
        if (pick % 2 == 0) {
            // 第一个人选
            // 拿左侧的数
            win = win || !PredictTheWinner(nums, score1 + nums[left], score2, left + 1, right, pick + 1);
            // 拿右侧的数
            win = win || !PredictTheWinner(nums, score1 + nums[right], score2, left, right - 1, pick + 1);
        } else {
            // 第二个人选
            // 拿左侧的数
            win = win || !PredictTheWinner(nums, score1, score2 + nums[left], left + 1, right, pick + 1);
            // 拿右侧的数
            win = win || !PredictTheWinner(nums, score1, score2 + nums[right], left, right - 1, pick + 1);
        }
        return win;

    }
}
