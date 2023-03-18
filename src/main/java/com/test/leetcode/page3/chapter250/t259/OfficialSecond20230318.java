package com.test.leetcode.page3.chapter250.t259;

import java.util.Arrays;

/**
 * @ClassName: OfficialSecond20230318
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/18 08:54
 * @Version: 1.0
 */
public class OfficialSecond20230318 {

    /**
     * 方法三：双指针 [通过]
     * <p>
     * 执行用时：13 ms, 在所有 Java 提交中击败了61.24%的
     * 用户内存消耗：41.2 MB, 在所有 Java 提交中击败了55.62%的用户
     * 通过测试用例：316 / 316
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            sum += twoSumSmaller(nums, i + 1, target - nums[i]);
        }
        return sum;
    }

    private int twoSumSmaller(int[] nums, int startIndex, int target) {
        int sum = 0;
        int left = startIndex;
        int right = nums.length - 1;
        while (left < right) {
            // 跪了，跪了，唉唉唉
            if (nums[left] + nums[right] < target) {
                sum += right - left;
                left++;
            } else {
                right--;
            }
        }
        return sum;
    }
}
