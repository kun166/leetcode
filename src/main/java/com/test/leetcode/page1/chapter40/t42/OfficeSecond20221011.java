package com.test.leetcode.page1.chapter40.t42;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: OfficeSecond20221011
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/11 16:59
 * @Version: 1.0
 */
public class OfficeSecond20221011 {

    /**
     * 单调栈解法，非常精彩的思路
     * 维护一个单调栈，单调栈存储的是下标，满足从栈底到栈顶的下标对应的数组 height 中的元素递减。
     * 单调栈的定义可以参考：https://zhuanlan.zhihu.com/p/409626118
     * <p>
     * stack<int> stk;
     * for (遍历这个数组){
     *    if (栈空 || 栈顶元素大于等于当前比较元素){
     *        入栈;
     *    }
     *    else{
     *        while (栈不为空 && 栈顶元素小于当前元素){
     *             栈顶元素出栈;
     *             更新结果;
     *         }
     *         当前数据入栈;
     *    }
     * }
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int ans = 0;
        // 单调递减栈
        Deque<Integer> stack = new LinkedList<>();
        int n = height.length;
        for (int i = 0; i < n; ++i) {
            // 抛开当前下标后面的不算，只算当前下标前面的。如果当前下标高度小于等于前面最小的，肯定不存水
            // stack.peek() 的前提条件是!stack.isEmpty()
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                // 弹出栈顶top，因为是单调递减栈，所以这个top是栈里面最小的。比top小的那些接水点也都已经计算且累加过了
                int top = stack.pop();
                // 如果此时栈空了，则因为左边没有柱子挡水了，就退出当前while循环
                if (stack.isEmpty()) {
                    break;
                }
                // 取出top下面的柱子，开始计算存的水
                int left = stack.peek();
                // left坐标和当前坐标的距离，也即宽度
                int currWidth = i - left - 1;
                // 宽度，注意比top小的那些存水点都已经被top计算累加过了，所以这个地方高度需要减去top的高度
                int currHeight = Math.min(height[left], height[i]) - height[top];
                // 累加
                ans += currWidth * currHeight;
            }
            // 将当前坐标入栈
            stack.push(i);
        }
        return ans;
    }
}
