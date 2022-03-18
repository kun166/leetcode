package com.test.leetcode.page1.chapter40.t45;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-29 17:41
 */
public class OfficialSolution {

    @Test
    public void test() {
        System.out.println(jump(new int[]{2, 3, 1, 2, 4, 2, 3}));
    }

    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            // i+nums[i] 是这个i点可以跨越的最长的距离
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                // 不太好理解啊，这个地方
                //  如果当前节点已经到了它能跨越的最大距离点，就更新下一个最大跳跃点
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
