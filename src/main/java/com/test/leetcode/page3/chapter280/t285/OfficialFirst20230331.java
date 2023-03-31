package com.test.leetcode.page3.chapter280.t285;

import com.test.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: OfficialFirst20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 09:44
 * @Version: 1.0
 */
public class OfficialFirst20230331 {

    /**
     * 方法一：中序遍历
     * 利用中序遍历排好序的特性，如果当前节点curr的前一个节点是p，
     * 则p的下一个节点一定是当前节点curr，返回curr
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }

}
