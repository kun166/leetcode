package com.test.leetcode.page3.chapter230.t235;

import com.test.leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Solution20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 14:57
 * @Version: 1.0
 */
public class SolutionFirst20230309 {

    /**
     * 最先想到的方式查找
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> map = new HashMap<>();
        initMap(root, map);
        Set<TreeNode> set = new HashSet<>();
        TreeNode pp = p;
        while (pp != null) {
            set.add(pp);
            pp = map.get(pp);
        }
        TreeNode qq = q;
        while (qq != null) {
            if (set.contains(qq)) {
                return qq;
            }
            qq = map.get(qq);
        }
        return null;
    }

    public void initMap(TreeNode root, Map<TreeNode, TreeNode> map) {
        if (root.left != null) {
            map.put(root.left, root);
            initMap(root.left, map);
        }
        if (root.right != null) {
            map.put(root.right, root);
            initMap(root.right, map);
        }
    }
}
