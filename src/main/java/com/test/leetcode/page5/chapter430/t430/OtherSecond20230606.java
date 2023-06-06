package com.test.leetcode.page5.chapter430.t430;

/**
 * @ClassName: OtherSecond20230606
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/6 08:50
 * @Version: 1.0
 */
public class OtherSecond20230606 {

    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    /**
     * 递归（优化）
     *
     * @param head
     * @return
     */
    Node dfs(Node head) {
        Node last = head;
        while (head != null) {
            if (head.child == null) {
                last = head;
                head = head.next;
            } else {
                Node tmp = head.next;
                Node childLast = dfs(head.child);
                head.next = head.child;
                head.child.prev = head;
                head.child = null;
                if (childLast != null) childLast.next = tmp;
                if (tmp != null) tmp.prev = childLast;
                last = head;
                head = childLast;
            }
        }
        return last;
    }
}
