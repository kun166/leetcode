package com.test.leetcode.page1.chapter90.t94;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: OfficialFirst20230104
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/4 09:00
 * @Version: 1.0
 */
public class OfficialFirst20230104 {

    /**
     * 递归中序遍历。递归方式，又好动，又好写
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);
        return res;
    }

    public void inorder(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
}
