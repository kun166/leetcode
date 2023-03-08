package com.test.leetcode.page3.chapter230.t230;

import com.test.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: OfficialFirst20230308
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/8 09:19
 * @Version: 1.0
 */
public class OfficialFirst20230308 {

    /**
     * 中序遍历
     *
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            --k;
            if (k == 0) {
                break;
            }
            root = root.right;
        }
        return root.val;
    }

}
