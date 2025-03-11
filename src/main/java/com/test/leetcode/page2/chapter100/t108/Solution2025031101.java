package com.test.leetcode.page2.chapter100.t108;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution2025031101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 11:17
 * @Version: 1.0
 */
public class Solution2025031101 {

    /**
     * 平衡二叉树?折半?
     *
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int lp, int rp) {
        if (lp > rp)
            return null;
        int mid = lp + ((rp - lp) >> 1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = sortedArrayToBST(nums, lp, mid - 1);
        node.right = sortedArrayToBST(nums, mid + 1, rp);
        return node;
    }
}
