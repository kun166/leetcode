package com.test.leetcode.page2.chapter170.t173;

import com.test.leetcode.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: OfficialSecond20230213
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/13 14:06
 * @Version: 1.0
 */
public class OfficialSecond20230213 {

    class BSTIterator {
        private TreeNode cur;
        private Deque<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            cur = root;
            stack = new LinkedList<TreeNode>();
        }

        public int next() {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            int ret = cur.val;
            cur = cur.right;
            return ret;
        }

        public boolean hasNext() {
            return cur != null || !stack.isEmpty();
        }
    }
}
