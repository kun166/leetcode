package com.test.leetcode.page1.chapter90.t99;

import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @ClassName: OfficialSecond20230116
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/16 15:19
 * @Version: 1.0
 */
public class OfficialSecond20230116 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(3, new TreeNode(1), new TreeNode(4, new TreeNode(2), null));
        recoverTree(root);
    }

    /**
     * 中序遍历
     *
     * @param root
     */
    public void recoverTree(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        // pred是中序遍历的上一个节点
        // x是第一个乱序的点，y是第二个乱序的点
        TreeNode x = null, y = null, pred = null;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pred != null && root.val < pred.val) {
                // 乱序了
                // 下面这个处理，感觉是牛啊
                y = root;
                if (x == null) {
                    x = pred;
                } else {
                    // 如果xy都有值了，就跳出循环。这个地方算是剪枝吧
                    break;
                }
            }
            pred = root;
            root = root.right;
        }

        swap(x, y);
    }

    public void swap(TreeNode x, TreeNode y) {
        int tmp = x.val;
        x.val = y.val;
        y.val = tmp;
    }
}
