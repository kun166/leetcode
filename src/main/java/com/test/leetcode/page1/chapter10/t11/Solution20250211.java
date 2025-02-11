package com.test.leetcode.page1.chapter10.t11;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution20250211
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/11 10:01
 * @Version: 1.0
 */
public class Solution20250211 {

    /**
     * 这个题好像有更好的解法，单调栈?
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        // 返回值
        int ans = 0, length = height.length;
        List<Integer> list = new ArrayList<>();
        // 从左向右
        // 记录的是下标
        list.add(0);
        for (int i = 1; i < length; i++) {
            for (int j = 0; j < list.size(); j++) {
                int v = list.get(j);
                ans = Math.max(ans, (i - v) * Math.min(height[i], height[v]));
            }
            if (height[i] > height[list.get(list.size() - 1)]) {
                list.add(i);
            }
        }

        // 从右向左
        list.clear();
        list.add(length - 1);
        for (int i = length - 2; i >= 0; i--) {
            for (int j = 0; j < list.size(); j++) {
                int v = list.get(j);
                ans = Math.max(ans, (v - i) * Math.min(height[i], height[v]));
            }
            if (height[i] > height[list.get(list.size() - 1)]) {
                list.add(i);
            }
        }

        return ans;
    }
}
