package com.test.leetcode.page1.chapter90.t95;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230107
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/7 8:29
 * @Version: 1.0
 */
public class Solution20230107 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(generateTrees(3)));
    }

    /**
     * 这是一个错误的方法，嗯，是的
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            int value = list.remove(i);
            TreeNode root = new TreeNode(value);
            generateTrees(list, ans, root, root);
            list.add(i, value);
        }
        return ans;
    }

    public void generateTrees(List<Integer> list, List<TreeNode> ans, TreeNode root, TreeNode current) {
        if (list.isEmpty()) {
            ans.add(JSON.parseObject(JSON.toJSONString(root), TreeNode.class));
            return;
        }
        // 生成左子树
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > current.val) {
                continue;
            }
            int value = list.remove(i);
            current.left = new TreeNode(value);
            generateTrees(list, ans, root, current.left);
            list.add(i, value);
        }
        // 生成右子树
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < current.val) {
                continue;
            }
            int value = list.remove(i);
            current.right = new TreeNode(value);
            generateTrees(list, ans, root, current.right);
            list.add(i, value);
        }
    }
}
