package com.test.leetcode.page2.chapter100.t107;

import com.test.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution2025031101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 10:55
 * @Version: 1.0
 */
public class Solution2025031101 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> ans = new LinkedList<>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> ll = new LinkedList<>();
        /**
         * offer和add一样，就是从尾插
         */
        ll.offer(root);
        while (!ll.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = ll.size();
            while (--size >= 0) {
                /**
                 * pop是removeFirst
                 * peek也是第一个
                 */
                TreeNode node = ll.pop();
                list.add(node.val);
                if (node.left != null)
                    ll.offer(node.left);
                if (node.right != null)
                    ll.offer(node.right);
            }
            /**
             * push是addFirst,插入头部
             */
            ans.push(list);
        }
        return ans;
    }
}
