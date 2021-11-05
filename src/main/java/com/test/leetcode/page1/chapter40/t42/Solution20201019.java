package com.test.leetcode.page1.chapter40.t42;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-19 15:47
 */
public class Solution20201019 {

    @Test
    public void test() {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int length = height.length;
        int sum = 0;
        for (int i = 0; i < length - 1; i++) {
            int next = findNext(height, i);
            int h = Math.min(height[i], height[next]);
            sum += h * (next - i - 1);
            for (int j = i + 1; j < next; j++) {
                sum -= height[j];
            }
            // 到最后一个坐标就结束
            if (next == length - 1) break;
            i = next - 1;
        }
        return sum;
    }

    /**
     * 查找第index之后，大于等于它的数。如果没有，则查找剩余的最大的数。
     *
     * @param height
     * @param index  当前数组的序列号
     * @return
     */
    public int findNext(int[] height, int index) {
        // 从它下一个位置开始找
        int maxIndex = index + 1;
        for (int i = index + 1; i < height.length; i++) {
            // 如果找到了大于等于的数，则立马返回。
            if (height[i] >= height[index]) return i;
            // 否则找次大的数
            if (height[maxIndex] < height[i]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
