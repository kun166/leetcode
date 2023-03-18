package com.test.leetcode.page3.chapter250.t259;

import java.util.Arrays;

/**
 * @ClassName: Other20230318
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/18 08:58
 * @Version: 1.0
 */
public class Other20230318 {

    public int threeSumSmaller(int[] nums, int target) {
        int n = nums.length;
        if (n < 3)
            return 0;
        Arrays.sort(nums);
        if (nums[0] + nums[1] + nums[2] >= target)
            return 0;
        if (nums[n - 3] + nums[n - 2] + nums[n - 1] < target)
            return n * (n - 1) * (n - 2) / 6;
        int ans = 0;
        for (int i = 0; i <= n - 3; i++) {
            int t = target - nums[i];
            if (nums[i + 1] + nums[i + 2] >= t)
                break;
            // 双指针
            for (int l = i + 1, r = n - 1; l < r; ) {
                if (nums[l] + nums[r] < t) {
                    // 这个地方秒啊,如果这个条件成立，则r从l+1到r都符合条件
                    ans += r - l;
                    l++;
                } else {
                    r--;
                }
            }
        }
        return ans;
    }
}
