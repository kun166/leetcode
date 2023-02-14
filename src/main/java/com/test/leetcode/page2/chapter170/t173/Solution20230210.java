package com.test.leetcode.page2.chapter170.t173;

import com.test.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20230210
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/10 14:29
 * @Version: 1.0
 */
public class Solution20230210 {

    /**
     * 呃呃呃,这不就是考的二叉树的中序遍历么
     */
    class BSTIterator {

        private Deque<Integer> deque;

        public BSTIterator(TreeNode root) {
            deque = new LinkedList<>();
            initDeque(root);
        }

        public int next() {
            return deque.pop();
        }

        public boolean hasNext() {
            return !deque.isEmpty();
        }

        private void initDeque(TreeNode root) {
            if (root == null) {
                return;
            }
            initDeque(root.right);
            deque.push(root.val);
            initDeque(root.left);
        }
    }
}
