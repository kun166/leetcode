package com.test.leetcode.page2.chapter170.t173;

import com.test.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Official20230213
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/13 14:04
 * @Version: 1.0
 */
public class OfficialFirst20230213 {

    /**
     * 扁平化
     */
    class BSTIterator {
        private int idx;
        private List<Integer> arr;

        public BSTIterator(TreeNode root) {
            idx = 0;
            arr = new ArrayList<Integer>();
            inorderTraversal(root, arr);
        }

        public int next() {
            return arr.get(idx++);
        }

        public boolean hasNext() {
            return idx < arr.size();
        }

        private void inorderTraversal(TreeNode root, List<Integer> arr) {
            if (root == null) {
                return;
            }
            inorderTraversal(root.left, arr);
            arr.add(root.val);
            inorderTraversal(root.right, arr);
        }
    }
}
