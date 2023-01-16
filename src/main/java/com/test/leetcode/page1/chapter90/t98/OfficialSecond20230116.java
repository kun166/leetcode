package com.test.leetcode.page1.chapter90.t98;

import com.test.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: OfficialSecond20230116
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/16 14:15
 * @Version: 1.0
 */
public class OfficialSecond20230116 {

    /**
     * 解法相当精妙，只能说我怎么没想到呢
     *
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
