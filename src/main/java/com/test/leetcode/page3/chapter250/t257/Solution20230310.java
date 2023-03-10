package com.test.leetcode.page3.chapter250.t257;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230310
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/10 17:46
 * @Version: 1.0
 */
public class Solution20230310 {

    public List<String> binaryTreePaths(TreeNode root) {
        StringBuilder builder = new StringBuilder();
        List<String> list = new ArrayList<>();
        builder.append(root.val);
        binaryTreePaths(root.left, list, builder);
        binaryTreePaths(root.right, list, builder);
        return list;
    }

    public void binaryTreePaths(TreeNode root, List<String> list, StringBuilder builder) {
        builder.append("->").append(root.val);
        int length = builder.length();
        if (root.left != null) {
            binaryTreePaths(root.left, list, builder);
        }
        if (root.right != null) {
            if (length < builder.length()) {
                builder.delete(length, builder.length());
            }
            binaryTreePaths(root.right, list, builder);
        }
        if (root.left == null && root.right == null) {
            list.add(builder.toString());
        }
    }
}
