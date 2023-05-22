package com.test.leetcode.page4.chapter330.t334;

/**
 * @ClassName: OfficialSecond20230427
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/27 08:51
 * @Version: 1.0
 */
public class OfficialSecond20230427 {

    /**
     * 贪心算法
     * 呃，我想复杂了……
     * 其实一旦确定了second，则确定second的first就不重要了……
     *
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return false;
        }
        int first = nums[0], second = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++) {
            int num = nums[i];
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}
