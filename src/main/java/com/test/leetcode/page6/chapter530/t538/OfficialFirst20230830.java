package com.test.leetcode.page6.chapter530.t538;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: OfficialFirst20230830
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/8/30 09:19
 * @Version: 1.0
 */
public class OfficialFirst20230830 {
    class Solution {

        int sum = 0;

        /**
         * 反中序遍历，这个好像很猛啊
         *
         * @param root
         * @return
         */
        public TreeNode convertBST(TreeNode root) {
            if (root != null) {
                convertBST(root.right);
                sum += root.val;
                root.val = sum;
                convertBST(root.left);
            }
            return root;
        }
    }
}
