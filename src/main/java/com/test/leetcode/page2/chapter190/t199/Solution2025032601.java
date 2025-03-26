package com.test.leetcode.page2.chapter190.t199;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 09:40
 * @Version: 1.0
 */
public class Solution2025032601 {

    /**
     * 最容易想到的:
     * 1,每一层从右向左存入队列
     * 2,队列的第一个元素即为所求
     * <p>
     * 1ms	击败77.57%
     * 41.23MB	击败88.30%
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> ll = new LinkedList<>();
        ll.offer(root);
        while (!ll.isEmpty()) {
            ans.add(ll.peek().val);
            int size = ll.size();
            while (size-- > 0) {
                TreeNode node = ll.pop();
                if (node.right != null) {
                    ll.offer(node.right);
                }
                if (node.left != null) {
                    ll.offer(node.left);
                }
            }
        }
        return ans;
    }
}
