package com.test.leetcode.page5.chapter400.t404;

import com.test.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName: OfficialSecond20230525
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/5/25 10:09
 * @Version: 1.0
 */
public class OfficialSecond20230525 {

    /**
     * 方法二：广度优先搜索
     *
     * @param root
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int ans = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (isLeafNode(node.left)) {
                    ans += node.left.val;
                } else {
                    queue.offer(node.left);
                }
            }
            if (node.right != null) {
                if (!isLeafNode(node.right)) {
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

    public boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
