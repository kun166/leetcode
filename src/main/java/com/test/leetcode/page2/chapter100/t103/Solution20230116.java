package com.test.leetcode.page2.chapter100.t103;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution20230116
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/16 17:50
 * @Version: 1.0
 */
public class Solution20230116 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<TreeNode> l = new LinkedList<>();
        l.add(root);
        TreeNode node;
        boolean fromLeft = true;
        while (!l.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int count = l.size();
            while (count > 0) {
                // 不论是从左向右，还是从右向左，都是反向取
                count--;
                node = l.remove(count);
                list.add(node.val);
                if (fromLeft) {
                    // 从左向右，先添加左节点，再添加右节点
                    if (node.left != null) {
                        l.add(node.left);
                    }
                    if (node.right != null) {
                        l.add(node.right);
                    }
                } else {
                    // 从右向左，先添加右节点，再添加左节点
                    if (node.right != null) {
                        l.add(node.right);
                    }
                    if (node.left != null) {
                        l.add(node.left);
                    }
                }
            }
            fromLeft = !fromLeft;
            ans.add(list);
        }
        return ans;
    }
}
