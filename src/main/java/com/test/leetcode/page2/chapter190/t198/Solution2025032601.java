package com.test.leetcode.page2.chapter190.t198;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 09:05
 * @Version: 1.0
 */
public class Solution2025032601 {

    private int ans = 0;

    /**
     * 嗯,如果能通过递归-回溯解决的,就一定能通过dp解决
     * 先试一下递归-回溯会不会超时
     * <p>
     * 果然不出所料……超出时间限制
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        backtrack(nums, true, 0, 0);
        return ans;
    }

    /**
     * @param nums
     * @param can   本次是否可以偷
     * @param index 本次的房间号
     * @param money 一共偷到的钱
     */
    public void backtrack(int[] nums, boolean can, int index, int money) {
        if (index == nums.length) {
            // 到达最后一间房间l
            ans = Math.max(ans, money);
            return;
        }

        // 不偷
        backtrack(nums, true, index + 1, money);
        // 偷
        if (can) {
            backtrack(nums, false, index + 1, money + nums[index]);
        }
    }
}
