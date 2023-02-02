package com.test.leetcode.page2.chapter140.t144;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.TreeNode;
import org.junit.Test;

import java.util.*;

/**
 * @ClassName: SolutionSecond20230202
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/2 18:18
 * @Version: 1.0
 */
public class SolutionSecond20230202 {

    @Test
    public void test() {
        TreeNode root = new TreeNode(2, new TreeNode(1, null, new TreeNode(4)), new TreeNode(3));
        System.out.println(JSON.toJSONString(root));
        System.out.println(JSON.toJSONString(preorderTraversal(root)));

    }

    /**
     * 来个迭代
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 第一次执行，这个地方用了queue，显然是不行的，队列是先进先出。这个得需要后进先出，明显得用栈(双端队列模拟)
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        while (root != null || !deque.isEmpty()) {
            // 下面这个是为了遍历左叶子节点
            while (root != null) {
                // 先遍历左节点
                list.add(root.val);
                deque.push(root);
                root = root.left;
            }
            // 下面是为了遍历右叶子节点
            root = deque.pop();
            root = root.right;
        }
        return list;
    }
}
