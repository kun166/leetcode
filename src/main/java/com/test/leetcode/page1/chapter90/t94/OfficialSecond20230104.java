package com.test.leetcode.page1.chapter90.t94;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: OfficialSecond20230104
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/4 09:02
 * @Version: 1.0
 */
public class OfficialSecond20230104 {

    /**
     * 迭代方式，非递归。看了官方解答之后，感觉简单，看了官方解答一遍又一遍，总是记不住
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
