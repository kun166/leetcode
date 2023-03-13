package com.test.leetcode.page2.chapter150.t156;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: SolutionSecond20230313
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/13 10:23
 * @Version: 1.0
 */
public class SolutionSecond20230313 {

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        // 看了下other解法，这个right变量可以省略
        TreeNode left, right, curLift = null, curRight = null;
        while (root != null) {
            left = root.left;
            right = root.right;
            root.left = curLift;
            root.right = curRight;
            curLift = right;
            curRight = root;
            root = left;
        }
        return curRight;
    }
}
