package com.test.leetcode.page4.chapter320.t325;

import org.junit.Test;

/**
 * @ClassName: SolutionSecond20230424
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/24 09:03
 * @Version: 1.0
 */
public class SolutionSecond20230424 {

    @Test
    public void test() {
        System.out.println(maxSubArrayLen(new int[]{-1, 1}, 1));
    }

    /**
     * 感觉记录一下比较好啊
     *
     * @param nums
     * @param k
     * @return
     */
    public int maxSubArrayLen(int[] nums, int k) {
        int ans = 0;
        int[] array = new int[nums.length];
        array[0] = nums[0];
        if (array[0] == k) {
            ans = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            array[i] = array[i - 1] + nums[i];
            if (array[i] == k) {
                ans = Math.max(ans, i + 1);
            }
        }
        for (int i = 1; i < nums.length; i++) {
            int j = nums.length - 1;
            while (j - i >= ans) {
                if (array[j] - array[i - 1] == k) {
                    ans = j - i + 1;
                }
                j--;
            }
        }
        return ans;
    }
}
