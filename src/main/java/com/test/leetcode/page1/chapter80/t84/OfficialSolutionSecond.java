package com.test.leetcode.page1.chapter80.t84;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-25 19:48
 */
public class OfficialSolutionSecond {

    @Test
    public void test() {
        System.out.println(largestRectangleArea(new int[]{5, 5, 5, 5, 5, 5}));
    }

    /**
     * 这种方式的left和right的值，对于数组{5, 5, 5, 5, 5, 5}，和上一种方式，是不一样的
     * 虽然结果相同
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(right, n);

        Stack<Integer> mono_stack = new Stack<>();
        for (int i = 0; i < n; ++i) {
            /**
             * 对于heights简化点来说,要么是单调递增,要么单调递减,要么是凸型,要么是凹型
             * 单调递增:
             * 这个时候的right[i]均为n……,这就解释了为什么都要用n填充了
             * 单调递减:
             * 此时对于left来说,left[i]记录的都是-1
             * 对于当前坐标i,都要小于i-1下标的高度,同样对于right来说的,i-1的右侧下标就是i
             * 凸型:
             * 凸型上的一个点,做x轴的平行线,交于图形两个点
             *
             */
            while (!mono_stack.isEmpty() && heights[mono_stack.peek()] >= heights[i]) {
                /**
                 * 对于平行线上的点,比如{5, 5, 5, 5, 5, 5}
                 * right[i]记录的都是i+1,
                 * 单点的面积计算有问题，但是不影响最大面积
                 */
                right[mono_stack.peek()] = i;
                mono_stack.pop();
            }
            left[i] = (mono_stack.isEmpty() ? -1 : mono_stack.peek());
            mono_stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
