package com.test.leetcode.page1.chapter40.t42;

import org.junit.Test;

/**
 * @ClassName: Solution20221011
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/11 15:49
 * @Version: 1.0
 */
public class Solution20221011 {

    @Test
    public void test() {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length - 1; i++) {
            if (height[i] == 0) {
                continue;
            }
            int next = findNext(height, i);
            if (next == i + 1) {
                // 相邻，没有面积
                continue;
            }
            //计算面积
            area += computerArea(height, i, next);
            // 调整i下标
            i = next - 1;
        }
        return area;
    }

    /**
     * 寻找下一个大于当前下标值的下标，或者剩余的数组里面最大的那个下标
     *
     * @param height
     * @param index
     * @return
     */
    public int findNext(int[] height, int index) {
        int next = index + 1;
        for (int i = index + 1; i < height.length; i++) {
            // 先找大于当前坐标值的下标
            if (height[i] >= height[index]) {
                return i;
            }
            // 不存在，则找剩余坐标里面值最大的那个下标
            if (height[i] > height[next]) {
                next = i;
            }
        }
        return next;
    }

    /**
     * 计算面积
     *
     * @param height
     * @param start
     * @param end
     * @return
     */
    public int computerArea(int[] height, int start, int end) {
        int area = (end - start - 1) * Math.min(height[start], height[end]);
        for (int i = start + 1; i < end; i++) {
            area -= height[i];
        }
        return area;
    }
}
