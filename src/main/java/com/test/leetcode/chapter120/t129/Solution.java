package com.test.leetcode.chapter120.t129;

import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-16 10:24
 */
public class Solution {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(sumNumbers(root));
    }

    public int sumNumbers(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        sumNumbers(root, 0, result);
        int sum = 0;
        for (int i : result) {
            sum += i;
        }
        return sum;
    }

    public void sumNumbers(TreeNode root, int pV, List<Integer> result) {
        if (root.left == null && root.right == null) {
            result.add(pV * 10 + root.val);
        }
        if (root.left != null) {
            sumNumbers(root.left, pV * 10 + root.val, result);
        }
        if (root.right != null) {
            sumNumbers(root.right, pV * 10 + root.val, result);
        }
    }
}
