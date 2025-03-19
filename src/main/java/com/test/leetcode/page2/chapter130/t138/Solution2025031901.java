package com.test.leetcode.page2.chapter130.t138;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution2025031901
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/19 15:33
 * @Version: 1.0
 */
public class Solution2025031901 {

    /**
     * 0ms	击败100.00%
     * 43.80MB	击败9.99%
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        Node h = head;
        map.put(h, new Node(h.val));
        while (h.next != null) {
            // 先不管random,先复制
            map.put(h.next, new Node(h.next.val));
            map.get(h).next = map.get(h.next);
            h = h.next;
        }
        // 赋值random
        h = head;
        while (h != null) {
            if (h.random != null) {
                map.get(h).random = map.get(h.random);
            }
            h = h.next;
        }
        return map.get(head);
    }
}
