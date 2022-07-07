package com.test.leetcode.page1.chapter10.t15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20220628
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/6/28 17:10
 * @Version: 1.0
 */
public class Solution20220628 {


    public List<List<Integer>> threeSum(int[] nums) {
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    right--;
                    while (nums[right] == nums[right + 1] && right > left) {
                        right--;
                    }
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return list;
    }
}
