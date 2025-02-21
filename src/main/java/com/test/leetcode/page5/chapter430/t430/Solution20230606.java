package com.test.leetcode.page5.chapter430.t430;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Solution20230606
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/6 07:48
 * @Version: 1.0
 */
public class Solution20230606 {

    /**
     * 执行用时：0 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：39.5 MB, 在所有 Java 提交中击败了62.98%的用户
     * 通过测试用例：26 / 26
     *
     * @param head
     * @return
     */
    // 我感觉怎么可以用递归呢
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node ans = head;
        Deque<Node> deque = new LinkedList<>();
        while (head.next != null || head.child != null || !deque.isEmpty()) {
            if (head.child != null) {
                // 把下一个节点存在deque里
                if (head.next != null) {
                    deque.push(head.next);
                }
                // 建立父子前后关系
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                head = head.next;
            } else if (head.next != null) {
                head = head.next;
            } else {
                Node node = deque.pop();
                head.next = node;
                node.prev = head;
                head = node;
            }
        }
        return ans;
    }


}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
