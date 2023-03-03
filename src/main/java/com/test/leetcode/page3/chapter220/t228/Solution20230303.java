package com.test.leetcode.page3.chapter220.t228;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230303
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/3 09:43
 * @Version: 1.0
 */
public class Solution20230303 {


    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        if (nums.length == 0) {
            return ans;
        } else if (nums.length == 1) {
            ans.add(String.valueOf(nums[0]));
            return ans;
        }
        int left = 0, right = 1;
        for (; right < nums.length; right++) {
            if (nums[right] != nums[right - 1] + 1) {
                if (left == right - 1) {
                    ans.add(String.valueOf(nums[left]));
                } else {
                    ans.add(nums[left] + "->" + nums[right - 1]);
                }
                left = right;
            }
        }
        if (left == right - 1) {
            ans.add(String.valueOf(nums[left]));
        } else {
            ans.add(nums[left] + "->" + nums[right - 1]);
        }
        return ans;
    }
}
