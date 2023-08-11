package com.test.leetcode.page6.chapter530.t532;

import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName: Solution20230810
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/10 16:52
 * @Version: 1.0
 */
public class SolutionSecond20230810 {

    @Test
    public void test() {
        System.out.println(findPairs(new int[]{1, 3, 1, 5, 4}, 0));
    }

    /**
     * 试试双指针?
     * 执行用时：4 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.2 MB, 在所有 Java 提交中击败了67.71%的用户
     * 通过测试用例：60 / 60
     *
     * @param nums
     * @param k
     * @return
     */
    public int findPairs(int[] nums, int k) {
        int ans = 0, n = nums.length;
        Arrays.sort(nums);
        int left = 0, right = 1;
        while (left < n && right < n) {
            if (nums[right] - nums[left] == k) {
                    ans++;
                    left++;
                    while (left < n && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (nums[right] - nums[left] < k) {
                    right++;
                } else {
                    left++;
            }
            if (left >= right) {
                right = left + 1;
            }
        }
        return ans;
    }
}
