package com.test.leetcode.page6.chapter500.t503;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: Solution20230713
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/13 15:45
 * @Version: 1.0
 */
public class Solution20230713 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(nextGreaterElements(new int[]{5, 4, 3, 2, 1})));
    }

    /**
     * 单调栈？
     * <p>
     * 执行用时：3 ms, 在所有 Java 提交中击败了98.58%的用户
     * 内存消耗：43.7 MB, 在所有 Java 提交中击败了37.67%的用户
     * 通过测试用例：223 / 223
     *
     * @param nums
     * @return
     */
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> deque = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];
        // 第一轮，先找到最大的那个数
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[index]) {
                index = i;
            }
        }
        ans[index] = -1;
        deque.push(nums[index]);

        int start = index + n - 1;
        while (start % n != index) {
            int i = start % n;
            while (!deque.isEmpty() && deque.peek() <= nums[i]) {
                deque.pop();
            }
            ans[i] = deque.isEmpty() ? -1 : deque.peek();
            deque.push(nums[i]);
            start--;
        }

        return ans;
    }
}
