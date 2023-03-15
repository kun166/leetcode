package com.test.leetcode.page3.chapter250.t250;

import com.test.leetcode.TreeNode;

/**
 * @ClassName: OfficialSecond20230315
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/15 09:37
 * @Version: 1.0
 */
public class OfficialSecond20230315 {
    int count = 0;

    /**
     * 方法二：传父值的深度优先搜索
     * <p>
     * 呃，这解法比上一个难理解，但是也很牛啊
     *
     * @param node
     * @param val
     * @return
     */
    boolean is_valid_part(TreeNode node, int val) {

        // considered a valid subtree
        if (node == null) return true;

        // check if node.left and node.right are univalue subtrees of value node.val
        // note that || short circuits but | does not - both sides of the or get evaluated with | so we explore all possible routes
        if (!is_valid_part(node.left, node.val) | !is_valid_part(node.right, node.val))
            return false;

        // if it passed the last step then this a valid subtree - increment
        // 说明当前节点的值和左右子树的值相同，且左右子树都是同值树
        count++;

        // at this point we know that this node is a univalue subtree of value node.val
        // pass a boolean indicating if this is a valid subtree for the parent node
        return node.val == val;
    }

    public int countUnivalSubtrees(TreeNode root) {
        is_valid_part(root, 0);
        return count;
    }
}
