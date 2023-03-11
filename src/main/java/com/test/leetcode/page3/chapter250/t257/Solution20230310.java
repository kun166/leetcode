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
        binaryTreePaths(root, list, builder);
        return list;
    }

    public void binaryTreePaths(TreeNode root, List<String> list, StringBuilder builder) {
        builder.append(root.val).append("->");
        if (root.left == null && root.right == null) {
            // 这个地方，如果是一个参数的话，是截取的参数之后的字符串……
            list.add(builder.substring(0, builder.length() - 2));
        }
        int length = builder.length();
        if (root.left != null) {
            binaryTreePaths(root.left, list, builder);
            builder.delete(length, builder.length());
        }
        if (root.right != null) {
            binaryTreePaths(root.right, list, builder);
        }
    }
}
