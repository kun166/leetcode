package com.test.leetcode.chapter100.t106;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-05-20 09:46
 */
public class Solution {

    private Map<Integer, Integer> map = new HashMap<>();


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder, int inorderS, int inorderE, int postorderS, int postorderE) {
        if (postorderS > postorderE) {
            return null;
        }
        int rootIndex = postorderE;
        // 构造root
        TreeNode root = new TreeNode(postorder[rootIndex]);
        // 找出该root在中序遍历的位置
        int inorderIndex = map.get(postorder[rootIndex]);
        //int leftLength = inorderIndex - inorderS;

        root.right = buildTree(inorder, postorder, inorderIndex + 1, inorderE, postorderS + inorderIndex - inorderS, postorderE - 1);
        root.left = buildTree(inorder, postorder, inorderS, inorderIndex - 1, postorderS, postorderS + inorderIndex - inorderS - 1);
        return root;
    }


    @Test
    public void test() {
        TreeNode node = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
        System.out.println(JSON.toJSONString(node));
    }

}
