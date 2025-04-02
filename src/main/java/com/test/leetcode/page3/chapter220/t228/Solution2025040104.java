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
public class Solution2025040104 {

    /**
     * 0ms	击败100.00%
     * 40.83MB	击败67.55%
     * <p>
     * 呃,我只能说不可思议……不理解……
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
                StringBuilder builder = new StringBuilder();
                builder.append(start);
                if (start != nums[i - 1]) {
                    builder.append("->").append(nums[i - 1]);
                }
                ans.add(builder.toString());
                start = nums[i];
            }
        }
        StringBuilder builder = new StringBuilder();
        builder.append(start);
        if (start != nums[i - 1]) {
            builder.append("->").append(nums[i - 1]);
        }
        ans.add(builder.toString());
        return ans;
    }
}
