package com.test.leetcode.page3.chapter220.t228;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025040101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/4/1 17:36
 * @Version: 1.0
 */
public class Solution2025040101 {

    /**
     * 8ms	击败11.19%
     * 41.24MB	击败5.12%
     *
     * @param nums
     * @return
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int n = nums.length;
        if (n == 0) {
            return ans;
        }
        int start = nums[0], i = 1;
        for (; i < n; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                ans.add(start + (start == nums[i - 1] ? "" : "->" + nums[i - 1]));
                start = nums[i];
            }
        }
        ans.add(start + (start == nums[i - 1] ? "" : "->" + nums[i - 1]));
        return ans;
    }
}
