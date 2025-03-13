package com.test.leetcode.page2.chapter110.t116;

/**
 * @ClassName: Official20230120
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/20 14:24
 * @Version: 1.0
 */
public class Official20230120 {

    /**
     * 呃，好吧，这个题的前提是完美二叉树……
     *
     * @param root
     * @return
     */
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        // 从根节点开始
        Node leftmost = root;
        // 第一层循环，方向向下
        while (leftmost.left != null) {
            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;
            // 第二层循环，方向向右
            while (head != null) {
                // CONNECTION 1
                head.left.next = head.right;
                // CONNECTION 2
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 指针向后移动
                head = head.next;
            }
            // 去下一层的最左的节点
            leftmost = leftmost.left;
        }
        return root;
    }
}
