package com.test.leetcode.page5.chapter420.t429;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution20230606
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/6 07:30
 * @Version: 1.0
 */
public class Solution20230606 {

    /**
     * 执行用时：3 ms, 在所有 Java 提交中击败了86.47%的用户
     * 内存消耗：43.1 MB, 在所有 Java 提交中击败了20.48%的用户
     * 通过测试用例：38 / 38
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Deque<Node> deque = new LinkedList<>();
        deque.offer(root);
        while (!deque.isEmpty()) {
            int size = deque.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node current = deque.pop();
                list.add(current.val);
                if (current.children != null) {
                    for (Node node : current.children) {
                        deque.offer(node);
                    }
                }
            }
            ans.add(list);
        }
        return ans;
    }

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    ;
}

