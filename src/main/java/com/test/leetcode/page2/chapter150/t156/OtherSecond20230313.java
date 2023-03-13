package com.test.leetcode.page2.chapter150.t156;

import com.test.leetcode.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: OtherSecond20230313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 10:37
 * @Version: 1.0
 */
public class OtherSecond20230313 {

    // 迭代栈版本 从左下往右上遍历
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return null;
        Deque<TreeNode> stack = new ArrayDeque<>();
        // 一直往左扎，找到最左侧的叶节点作为新的根节点
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        // 此时栈顶就是最左侧的节点
        TreeNode newRoot = stack.pop();
        TreeNode x = null, y = newRoot, z = null;
        while (!stack.isEmpty()) {
            x = stack.pop(); // x 向上移动

            z = x.right;
            y.left = z; // y的左指针指向z
            y.right = x; // y的右指针指向x
            x.left = x.right = null; // 断开x的左右指针

            y = x; // y向上移动到x位置
        }
        return newRoot; // 返回新的根节点
    }
}
