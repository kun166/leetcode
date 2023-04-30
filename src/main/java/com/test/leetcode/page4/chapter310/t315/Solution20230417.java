package com.test.leetcode.page4.chapter310.t315;

import org.junit.Test;

import java.util.*;

/**
 * @ClassName: Solution20230417
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/17 09:56
 * @Version: 1.0
 */
public class Solution20230417 {

    @Test
    public void test() {
        System.out.println(countSmaller(new int[]{5, 2, 6, 1}));
    }

    /**
     * 超时
     *
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
            ans.add(count);
        }
        return ans;
    }
}
