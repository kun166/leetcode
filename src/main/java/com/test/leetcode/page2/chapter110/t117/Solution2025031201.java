package com.test.leetcode.page2.chapter110.t117;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.LinkedList;

/**
 * @ClassName: Solution20250312
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/12 11:14
 * @Version: 1.0
 */
public class Solution2025031201 {

    @Test
    public void test() {
        Node node = init(new Integer[]{2, 1, 3, 0, 7, 9, 1, 2, null, 1, 0, null, null, 8, 8, null, null, null, null, 7});
        node = connect(node);
        System.out.println(JSON.toJSONString(node));
    }

    Node init(Integer[] array) {
        int length = array.length;
        Node node = new Node(array[0]);
        LinkedList<Node> ll = new LinkedList();
        ll.offer(node);
        for (int i = 1; i < length; ) {
            int size = ll.size();
            while (size-- > 0 && i < length) {
                Node n = ll.pop();
                Integer number = array[i++];
                if (number != null) {
                    n.left = new Node(number);
                    ll.offer(n.left);
                }
                if (i < length) {
                    number = array[i++];
                    if (number != null) {
                        n.right = new Node(number);
                        ll.offer(n.right);
                    }
                }
            }
        }
        return node;
    }

    /**
     * 初次看，这题和116很相似，但是区别很大……
     * <p>
     * 0ms 击败100.00%
     * 43.64MB 击败7.56%
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null)
            return null;
        if (root.left != null) {
            if (root.right != null)
                root.left.next = root.right;
            else
                root.left.next = next(root);
        }
        if (root.right != null)
            root.right.next = next(root);
        /**
         * 呃，必须先遍历right,再遍历left
         * 因为先遍历left,可能父节层的next都没关联完整……
         */
        connect(root.right);
        connect(root.left);
        return root;
    }

    public Node next(Node node) {
        /**
         * 错误的代码
         */
//        while (node.next != null) {
//            node = node.next;
//            if (node.left != null)
//                return node.left;
//            if (node.right != null)
//                return node.right;
//        }
        /**
         * 正确的代码
         */
        node = node.next;
        while (node != null) {
            if (node.left != null)
                return node.left;
            if (node.right != null)
                return node.right;
            node = node.next;
        }
        return null;
    }
}
