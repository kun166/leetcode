package com.test.leetcode.page3.chapter250.t255;

import java.util.Stack;

/**
 * @ClassName: OtherSecond20230317
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/17 09:06
 * @Version: 1.0
 */
public class OtherSecond20230317 {

    /**
     * 方法二：单调栈
     * 单调递减。
     * 这个算法比较难理解，但是是牛逼的算法
     *
     * @param preorder
     * @return
     */
    public boolean verifyPreorder(int[] preorder) {
        if (preorder.length <= 2) {
            return true;
        }
        Stack<Integer> stack = new Stack<>();
        // 开始设置 min = Integer.MIN_VALUE,把根节点左侧的左子树的值都压入栈中
        int min = Integer.MIN_VALUE;
        for (int cur : preorder) {
            if (cur < min) {
                return false;
            }
            while (!stack.isEmpty() && cur > stack.peek()) {
                // 说明碰到了右子树。此时记录当前根节点，并且把当前根节点和当前根节点的所有左子树的值都弹出栈
                min = stack.pop();
            }
            stack.push(cur);
        }
        return true;
    }
}
