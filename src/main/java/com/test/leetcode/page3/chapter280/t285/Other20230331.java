package com.test.leetcode.page3.chapter280.t285;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: Other20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 09:40
 * @Version: 1.0
 */
public class Other20230331 {

    /**
     * 这代码，直接给跪了啊
     *
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        TreeNode res = null;
        while (root != null) {
            if (p.val < root.val) {
                // 如果当前节点的值大于p的值，则渐进式逼近寻找
                res = root;
                root = root.left;
            } else {
                // 如果当前节点的值小于p的值，则只能去当前节点的右子树上寻找
                root = root.right;
            }
        }
        return res;
    }
}
