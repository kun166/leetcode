package com.test.leetcode.page1.chapter90.t95;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution2025030701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/7 17:49
 * @Version: 1.0
 */
public class Solution2025030701 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(generateTrees(3)));
    }


    /**
     * 1ms 击败99.08%
     * 43.95MB 击败9.84%
     *
     * @param n
     * @return
     */
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }


    public List<TreeNode> generateTrees(int left, int right) {
        if (left > right) {
            return null;
        }
        List<TreeNode> ans = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            List<TreeNode> l = generateTrees(left, i - 1);
            List<TreeNode> r = generateTrees(i + 1, right);
            if (l == null && r == null) {
                ans.add(new TreeNode(i));
            } else if (l != null && r != null) {
                for (TreeNode lt : l) {
                    for (TreeNode rt : r) {
                        ans.add(new TreeNode(i, lt, rt));
                    }
                }
            } else if (l != null) {
                for (TreeNode lt : l) {
                    ans.add(new TreeNode(i, lt, null));
                }
            } else {
                for (TreeNode rt : r) {
                    ans.add(new TreeNode(i, null, rt));
                }
            }
        }
        return ans;
    }
}
