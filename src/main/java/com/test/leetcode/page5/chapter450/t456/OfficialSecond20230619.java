package com.test.leetcode.page5.chapter450.t456;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: OfficialSecond20230619
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/19 09:33
 * @Version: 1.0
 */
public class OfficialSecond20230619 {

    /**
     * 方法二：枚举1
     * 寻找1，单调栈是2，maxK是真正可以作为2的最大值
     *
     * @param nums
     * @return
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        // 单调栈
        Deque<Integer> candidateK = new LinkedList<Integer>();
        // 从右向左枚举
        candidateK.push(nums[n - 1]);
        int maxK = Integer.MIN_VALUE;

        for (int i = n - 2; i >= 0; --i) {
            if (nums[i] < maxK) {
                // 说明nums[i]是1
                return true;
            }
            while (!candidateK.isEmpty() && nums[i] > candidateK.peek()) {
                // maxK是可以作为2的最大值
                maxK = candidateK.pop();
            }
            if (nums[i] > maxK) {
                candidateK.push(nums[i]);
            }
        }

        return false;
    }

}
