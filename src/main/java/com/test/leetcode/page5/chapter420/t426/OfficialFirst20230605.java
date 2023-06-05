package com.test.leetcode.page5.chapter420.t426;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: OfficialFirst20230605
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/5 16:56
 * @Version: 1.0
 */
public class OfficialFirst20230605 {
    // the smallest (first) and the largest (last) nodes
    Node first = null;
    Node last = null;

    @Test
    public void test() {
        Node root = new Node(4, new Node(2, new Node(1), new Node(3)), new Node(5));
        root = treeToDoublyList(root);
        System.out.println(JSON.toJSONString(root));
    }

    public void helper(Node node) {
        if (node != null) {
            // left
            helper(node.left);
            // node
            if (last != null) {
                // link the previous node (last)
                // with the current one (node)
                last.right = node;
                node.left = last;
            } else {
                // keep the smallest node
                // to close DLL later on
                first = node;
            }
            last = node;
            // right
            helper(node.right);
        }
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;

        helper(root);
        // close DLL
        last.right = first;
        first.left = last;
        return first;
    }
}
