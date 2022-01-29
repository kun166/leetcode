package com.test.leetcode.page1.chapter10.t18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20220126
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/1/26 14:41
 * @Version: 1.0
 */
public class Solution20220126 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        if (length < 4) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int start = j + 1, end = length - 1;
                while (start < end) {
                    if (start > j + 1 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    if (end < length - 1 && nums[end] == nums[end + 1]) {
                        end--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[start] + nums[end] - target;
                    if (sum == 0) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                    } else if (sum < 0) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
