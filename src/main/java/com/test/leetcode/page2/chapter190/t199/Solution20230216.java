package com.test.leetcode.page2.chapter190.t199;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution20230216
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/16 10:55
 * @Version: 1.0
 */
public class Solution20230216 {

    /**
     * 这题显然是用层序遍历最舒服，最好写了
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> deque = new LinkedList();
        deque.add(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            ans.add(deque.peekLast().val);
            while (size > 0) {
                TreeNode node = deque.pop();
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
                size--;
            }
        }
        return ans;
    }
}
