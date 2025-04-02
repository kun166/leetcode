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
public class Solution2025040102 {

    /**
     * 呃,能折半?
     * <p>
     * 输入nums = [0,1,2,4]
     * 输出["0->1","2","4"]
     * 预期结果["0->2","4"]
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
        int left = 0, right = n - 1, pl, pr;
        while (left < n) {
            pl = left;
            pr = right;
            while (pl <= pr) {
                if (pr - pl == nums[pr] - nums[pl]) {
                    ans.add(nums[pl] + (pl == pr ? "" : "->" + nums[pr]));
                    pl = pr + 1;
                } else {
                    pr = pl + ((pr - pl) >> 1);
                }
            }
            left = pl;
        }

        return ans;
    }
}
