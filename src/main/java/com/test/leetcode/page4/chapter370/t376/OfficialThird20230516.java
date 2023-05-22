package com.test.leetcode.page4.chapter370.t376;

/**
 * @ClassName: OfficialThird20230516
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/16 07:33
 * @Version: 1.0
 */
public class OfficialThird20230516 {

    /**
     * 方法三：贪心
     *
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }
}
