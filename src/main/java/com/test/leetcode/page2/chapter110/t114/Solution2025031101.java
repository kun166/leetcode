package com.test.leetcode.page2.chapter110.t114;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @ClassName: Solution2025031101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 16:51
 * @Version: 1.0
 */
public class Solution2025031101 {


    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(3), new TreeNode(4)), new TreeNode(5, null, new TreeNode(6)));
        flatten(root);
        System.out.println(JSON.toJSONString(root));
    }

    /**
     * 唉，怎么感觉递归不太好写呢？迭代吧？
     *
     * @param root
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        LinkedList<TreeNode> ll = new LinkedList();
        LinkedList<TreeNode> l = new LinkedList();
        while (root != null || !ll.isEmpty()) {
            while (root != null) {
                ll.push(root);
                l.push(root);
                root = root.left;
            }
            TreeNode node = ll.pop();
            root = node.right;
        }

        TreeNode next = null;
        while (!l.isEmpty()) {
            TreeNode node = l.pop();
            node.right = next;
            node.left = null;
            next = node;
        }
    }
}
