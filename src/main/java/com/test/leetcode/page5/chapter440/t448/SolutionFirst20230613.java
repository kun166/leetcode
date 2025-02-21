package com.test.leetcode.page5.chapter440.t448;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230613
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/13 09:24
 * @Version: 1.0
 */
public class SolutionFirst20230613 {

    /**
     * 执行用时：6 ms, 在所有 Java 提交中击败了37.24%的用户
     * 内存消耗：52.1 MB, 在所有 Java 提交中击败了13.72%的用户
     * 通过测试用例：34 / 34
     *
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 当前下标的值，看下标等于该值的数，是否是正数，如果是则取反
            if (nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}
