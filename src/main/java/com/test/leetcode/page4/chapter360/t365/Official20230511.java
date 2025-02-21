package com.test.leetcode.page4.chapter360.t365;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 * @ClassName: Solution20230511
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/11 10:45
 * @Version: 1.0
 */
public class Official20230511 {

    public boolean canMeasureWater(int x, int y, int z) {
        Deque<int[]> stack = new LinkedList<int[]>();
        stack.push(new int[]{0, 0});
        Set<Long> seen = new HashSet<Long>();
        while (!stack.isEmpty()) {
            if (seen.contains(hash(stack.peek()))) {
                stack.pop();
                continue;
            }
            seen.add(hash(stack.peek()));

            int[] state = stack.pop();
            int remain_x = state[0], remain_y = state[1];
            if (remain_x == z || remain_y == z || remain_x + remain_y == z) {
                return true;
            }
            // 把 X 壶灌满。
            stack.push(new int[]{x, remain_y});
            // 把 Y 壶灌满。
            stack.push(new int[]{remain_x, y});
            // 把 X 壶倒空。
            stack.push(new int[]{0, remain_y});
            // 把 Y 壶倒空。
            stack.push(new int[]{remain_x, 0});
            // 把 X 壶的水灌进 Y 壶，直至灌满或倒空。
            stack.push(new int[]{remain_x - Math.min(remain_x, y - remain_y), remain_y + Math.min(remain_x, y - remain_y)});
            // 把 Y 壶的水灌进 X 壶，直至灌满或倒空。
            stack.push(new int[]{remain_x + Math.min(remain_y, x - remain_x), remain_y - Math.min(remain_y, x - remain_x)});
        }
        return false;
    }

    public long hash(int[] state) {
        return (long) state[0] * 1000001 + state[1];
    }
}
