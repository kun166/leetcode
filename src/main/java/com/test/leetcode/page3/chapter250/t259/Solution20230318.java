package com.test.leetcode.page3.chapter250.t259;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20230318
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/18 08:13
 * @Version: 1.0
 */
public class Solution20230318 {

    @Test
    public void test() {
        System.out.println(threeSumSmaller(new int[]{3, 1, 0, -2}, 4));
    }

    /**
     * 执行用时：27 ms, 在所有 Java 提交中击败了14.61%的用户
     * 内存消耗：41.3 MB, 在所有 Java 提交中击败了45.51%的用户
     * 通过测试用例：316 / 316
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumSmaller(int[] nums, int target) {
        int ans = 0, n = nums.length;
        if (n < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n - 2; i++) {
            int left = i + 1, right = n - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < target) {
                    ans++;
                    left++;
                    // 吐血，这个地方没加，唉
                    if (left == right && right > i + 2) {
                        right--;
                        left = i + 1;
                    }
                } else {
                    right--;
                    left = i + 1;
                }
            }
        }
        return ans;
    }
}
