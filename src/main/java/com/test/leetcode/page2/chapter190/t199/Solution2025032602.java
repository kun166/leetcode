package com.test.leetcode.page2.chapter190.t199;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution2025032601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/26 09:40
 * @Version: 1.0
 */
public class Solution2025032602 {


    /**
     * 来个递归吧
     * <p>
     * 0ms	击败100.00%
     * 41.36MB	击败55.84%
     * <p>
     * 有点假啊,递归居然速度更快……
     *
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        backtrack(root, 1, ans);
        return ans;
    }

    public void backtrack(TreeNode root, int row, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (ans.size() < row) {
            ans.add(root.val);
        }
        backtrack(root.right, row + 1, ans);
        backtrack(root.left, row + 1, ans);
    }
}
