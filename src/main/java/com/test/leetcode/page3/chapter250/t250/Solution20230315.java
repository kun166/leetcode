package com.test.leetcode.page3.chapter250.t250;

import com.test.leetcode.TreeNode;
import org.junit.Test;

/**
 * @ClassName: Solution20230315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/15 09:05
 * @Version: 1.0
 */
public class Solution20230315 {

    int ans;

    public int countUnivalSubtrees(TreeNode root) {
        if (root == null) {
            return 0;
        }
        univalSubtrees(root);
        return ans;
    }

    public boolean univalSubtrees(TreeNode root) {
        if (root.left == null && root.right == null) {
            ans++;
            return true;
        }
        boolean equal = true;
        if (root.left != null) {
            equal = equal & univalSubtrees(root.left) && root.val == root.left.val;
        }
        if (root.right != null) {
            equal = equal & univalSubtrees(root.right) && root.val == root.right.val;
        }
        if (equal) {
            ans++;
        }
        return equal;
    }
}
