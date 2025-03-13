package com.test.leetcode.page2.chapter110.t117;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

/**
 * @ClassName: Solution2025031202
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/12 15:11
 * @Version: 1.0
 */
public class Solution2025031202 {

    @Test
    public void test() {
        Node node = new Node(1, new Node(2, new Node(4), new Node(5), null), new Node(3, null, new Node(7), null), null);
        System.out.println(JSON.toJSONString(node));
        System.out.println(JSON.toJSONString(connect(node)));
    }

    public Node connect(Node root) {
        // 按层遍历
        Node parent = root;
        while (parent != null) {
            // 下一层的起点
            Node nextRow = null;
            while (parent != null) {
                if (parent.left != null) {
                    nextRow = nextRow == null ? parent.left : nextRow;
                    parent.left.next = parent.right == null ? nextNode(parent) : parent.right;
                }
                if (parent.right != null) {
                    nextRow = nextRow == null ? parent.right : nextRow;
                    parent.right.next = nextNode(parent);
                }
                parent = parent.next;
            }
            parent = nextRow;
        }
        return root;
    }


    public Node nextNode(Node root) {
        root = root.next;
        while (root != null) {
            if (root.left != null)
                return root.left;
            if (root.right != null)
                return root.right;
            root = root.next;
        }
        return null;
    }
}
