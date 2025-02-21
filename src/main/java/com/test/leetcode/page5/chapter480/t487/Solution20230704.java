package com.test.leetcode.page5.chapter480.t487;

/**
 * @ClassName: Solution20230704
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/4 08:51
 * @Version: 1.0
 */
public class Solution20230704 {

    /**
     * 边界很重要啊，失败了两次
     * 第一次，没+1
     * 第二次，循环外未处理
     * 第三次，没判断nums.length
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：43.5 MB, 在所有 Java 提交中击败了25.06%的用户
     * 通过测试用例：44 / 44
     *
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0, pre = 0, cur = 0;
        for (int i : nums) {
            if (i == 0) {
                ans = Math.max(ans, pre + cur + 1);
                pre = cur;
                cur = 0;
            } else {
                cur++;
            }
        }
        ans = Math.max(ans, pre + cur + 1);
        return ans > nums.length ? nums.length : ans;
    }
}
