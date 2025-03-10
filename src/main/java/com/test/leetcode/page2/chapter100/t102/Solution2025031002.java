package com.test.leetcode.page2.chapter100.t102;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution2025031002
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/10 17:16
 * @Version: 1.0
 */
public class Solution2025031002 {

    /**
     * Solution202503100为啥那么慢呢
     * <p>
     * 1ms 击败93.37%
     * 44.04MB 击败79.84%
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        LinkedList<TreeNode> ll = new LinkedList();
        ll.add(root);
        while (!ll.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = ll.size();
            while (--size >= 0) {
                TreeNode node = ll.pop();
                list.add(node.val);
                if (node.left != null)
                    ll.add(node.left);
                if (node.right != null)
                    ll.add(node.right);
            }
            ans.add(list);
        }
        return ans;
    }
}
