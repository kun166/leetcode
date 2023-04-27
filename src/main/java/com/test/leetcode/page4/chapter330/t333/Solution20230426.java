package com.test.leetcode.page4.chapter330.t333;

import com.test.leetcode.TreeNode;
import org.junit.Test;

/**
 * @ClassName: Solution20230426
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/4/26 09:47
 * @Version: 1.0
 */
public class Solution20230426 {
    int max = 0;

    @Test
    public void test() {
        TreeNode root = new TreeNode(3, new TreeNode(2), new TreeNode(4, new TreeNode(1), null));
        System.out.println(largestBSTSubtree(root));
    }

    public int largestBSTSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isBSTSubtree1(root, null, null)) {
            max = Math.max(max, bstSubtree(root));
        }
        largestBSTSubtree(root.left);
        largestBSTSubtree(root.right);
        return max;
    }

    public boolean isBSTSubtree1(TreeNode root, TreeNode leftNode, TreeNode rightNode) {
        if (root == null) {
            return true;
        }
        boolean ans = isBSTSubtree1(root.left, leftNode, root) && isBSTSubtree1(root.right, root, rightNode);
        if (!ans) {
            return false;
        }
        if (root.left != null) {
            if (root.left.val >= root.val) {
                return false;
            }
            if (leftNode != null && leftNode.val >= root.left.val) {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val <= root.val) {
                return false;
            }
            if (rightNode != null && rightNode.val <= root.right.val) {
                return false;
            }
        }
        return true;
    }

    public int bstSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return bstSubtree(root.left) + bstSubtree(root.right) + 1;
    }
}
