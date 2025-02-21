package com.test.leetcode.page1.chapter10.t15;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Solution20250211
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/11 15:27
 * @Version: 1.0
 */
public class Solution20250211 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(threeSum(new int[]{-4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2})));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int length = nums.length;
        // 排序吧
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int left = i + 1, right = length - 1;
            while (left < right) {
                while (left > i + 1 && left < right && nums[left] == nums[left - 1])
                    left++;
                while (right < length - 1 && right > left && nums[right] == nums[right + 1])
                    right--;
                if (left == right)
                    break;
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                } else if (sum > 0) {
                    right--;
                } else
                    left++;
            }
        }
        return ans;
    }
}
