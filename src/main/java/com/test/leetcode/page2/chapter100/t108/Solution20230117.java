package com.test.leetcode.page2.chapter100.t108;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Solution20230117
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/17 14:45
 * @Version: 1.0
 */
public class Solution20230117 {

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    public TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = sortedArrayToBST(nums, start, mid - 1);
        root.right = sortedArrayToBST(nums, mid + 1, end);
        return root;
    }
}
