package com.test.leetcode.page1.chapter10.t15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20220125
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/1/25 13:02
 * @Version: 1.0
 */
public class Solution20220125 {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int start = i + 1, end = length - 1;
            while (start < end) {
                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if (nums[i] + nums[start] + nums[end] == 0) {
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                } else if (nums[i] + nums[start] + nums[end] < 0) {
                    start++;
                } else {
                    end--;
                }
            }
        }
        return result;
    }
}
