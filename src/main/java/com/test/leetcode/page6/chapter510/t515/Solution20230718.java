package com.test.leetcode.page6.chapter510.t515;

import com.test.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @ClassName: Solution20230718
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/7/18 17:28
 * @Version: 1.0
 */
public class Solution20230718 {

    /**
     * 执行用时：2 ms, 在所有 Java 提交中击败了87.13%的用户
     * 内存消耗：43 MB, 在所有 Java 提交中击败了42.97%的用户
     * 通过测试用例：78 / 78
     *
     * @param root
     * @return
     */
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        Deque<TreeNode> deque = new ArrayDeque<>();
        if (root != null) {
            deque.offer(root);
        }
        while (!deque.isEmpty()) {
            int max = Integer.MIN_VALUE;
            int size = deque.size();
            while (size > 0) {
                TreeNode node = deque.pop();
                max = Math.max(max, node.val);
                if (node.left != null) {
                    deque.offer(node.left);
                }
                if (node.right != null) {
                    deque.offer(node.right);
                }
                size--;
            }
            ans.add(max);
        }
        return ans;
    }
}
