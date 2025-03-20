package com.test.leetcode.page2.chapter140.t145;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution2025032001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 16:36
 * @Version: 1.0
 */
public class Solution2025032001 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        System.out.println(JSON.toJSONString(postorderTraversal(root)));
    }

    /**
     * 递归方式就不写了吧,直接迭代吧
     * 1ms	击败28.16%
     * 41.00MB	击败26.77%
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        LinkedList<TreeNode> ll = new LinkedList();
        TreeNode pre = null;
        while (root != null || !ll.isEmpty()) {
            while (root != null) {
                ll.push(root);
                root = root.left;
            }
            TreeNode node = ll.pop();
            if (node.right == pre) {
                // 说明是第二次过来,或者右子树为null
                ans.add(node.val);
                pre = node;
            } else {
                ll.push(node);
                root = node.right;
                pre = root;
            }

        }
        return ans;
    }
}
