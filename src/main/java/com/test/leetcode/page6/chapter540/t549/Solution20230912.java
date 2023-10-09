package com.test.leetcode.page6.chapter540.t549;

import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230912
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/9/12 16:22
 * @Version: 1.0
 */
public class Solution20230912 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5)), new TreeNode(3));
        System.out.println(longestConsecutive(root));
    }

    public int longestConsecutive(TreeNode root) {
        // 中序遍历吧
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        if (list.size() < 2) {
            return list.size();
        }
        int ans = 0;
        int length = 1;
        for (int i = 1; i < list.size(); i++) {
            if (length == 1 && Math.abs(list.get(i) - list.get(i - 1)) == 1) {
                length++;
            } else if (length > 1 && list.get(i) - list.get(i - 1) == list.get(i - 1) - list.get(i - 2)) {
                length++;
            } else {
                ans = Math.max(ans, length);
                length = 1;
            }
        }
        ans = Math.max(ans, length);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        dfs(root.left, list);
        list.add(root.val);
        dfs(root.right, list);
    }

}
