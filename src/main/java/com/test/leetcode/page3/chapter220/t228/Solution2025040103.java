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
public class Solution2025040103 {

    /**
     * 8ms	击败11.23%
     * 41.23MB	击败5.15%
     * <p>
     * 呃,真的是一顿操作猛如虎,一看结果二百五……
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
            while (pl < pr) {
                /**
                 * 怎么跳出循环?
                 */
                int mid = pl + ((pr - pl) >> 1);
                if (pl == mid) {
                    if (nums[pl] + 1 == nums[pr]) {
                        pl = pr;
                    } else {
                        pr = pl;
                    }
                } else if (mid - pl == nums[mid] - nums[pl]) {
                    pl = mid;
                } else {
                    pr = mid - 1;
                }
            }
            ans.add(nums[left] + (left == pl ? "" : "->" + nums[pl]));
            left = pl + 1;
        }
        return ans;
    }
}
