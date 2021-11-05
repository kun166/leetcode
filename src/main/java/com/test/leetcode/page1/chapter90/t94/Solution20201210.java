package com.test.leetcode.page1.chapter90.t94;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-10 19:54
 */
public class Solution20201210 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(3);
        root.left.left = new TreeNode(1);
        //root.left.left = new TreeNode(4);
        List<Integer> list = inorderTraversal(root);
        System.out.println(JSON.toJSONString(list));
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !deque.isEmpty()) {
            // 访问左子树
            // 访问根节点
            // 访问右子树
            //deque.push(root);
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            list.add(root.val);
            root = root.right;
        }
        return list;
    }
}
