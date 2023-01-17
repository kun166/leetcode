package com.test.leetcode.page2.chapter100.t103;

import com.test.leetcode.TreeNode;

import java.util.*;

/**
 * @ClassName: Official20230117
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/17 10:07
 * @Version: 1.0
 */
public class Official20230117 {

    /**
     * 官方的这个解法，思路又不同了。
     * 保存树节点的队列顺序，始终是从左向右。这种好处是，从头取，从尾部添加，互不影响
     * <p>
     * 然后返回的队列里面，会根据从左向右，还是从右向左，决定添加到队列头还是队列尾
     *
     * @param root
     * @return
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        // 返回结果
        List<List<Integer>> ans = new LinkedList<List<Integer>>();
        if (root == null) {
            return ans;
        }
        // 存放本层的所有树节点
        Queue<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            // 存放node的值
            Deque<Integer> levelList = new LinkedList<Integer>();
            // node队列的长度
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                // 从最上面取
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<Integer>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}
