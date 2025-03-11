package com.test.leetcode.page2.chapter100.t106;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.TreeNode;
import org.junit.Test;

/**
 * @ClassName: Solution2025031101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/11 09:56
 * @Version: 1.0
 */
public class Solution2025031101 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3})));
    }

    /**
     * 10 ms 击败6.96%
     * 43.20MB 击败98.06%
     *
     * @param inorder
     * @param postorder
     * @return
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return buildTree(inorder, postorder, 0, inorder.length - 1, inorder.length - 1, 0);
    }


    public TreeNode buildTree(int[] inorder, int[] postorder, int left, int right, int index, int rightCount) {
        if (left > right)
            return null;
        TreeNode node = new TreeNode(postorder[index]);
        for (int i = left; i <= right; i++) {
            if (inorder[i] == postorder[index]) {
                node.left = buildTree(inorder, postorder, left, i - 1, i - 1 - rightCount, rightCount);
                node.right = buildTree(inorder, postorder, i + 1, right, index - 1, rightCount + 1);
                /**
                 * 下面不加break
                 * 10 ms 击败6.96%
                 * 43.20MB 击败98.06%
                 *
                 * 加了break
                 * 4ms 击败26.88%
                 * 43.37MB 击败80.19%
                 */
                break;
            }
        }
        return node;
    }
}
