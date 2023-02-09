package com.test.leetcode.page2.chapter160.t169;

import java.util.Arrays;

/**
 * @ClassName: OfficialSecond20230209
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/9 16:18
 * @Version: 1.0
 */
public class OfficialSecond20230209 {

    /**
     * 呃，这个解法是认真的么
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
