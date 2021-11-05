package com.test.leetcode.page2.chapter130.t138;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-26 11:19
 */
public class Solution {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node n = head;
        while (n != null) {
            map.putIfAbsent(n, new Node(n.val));
            n = n.next;
        }
        n = head;
        while (n != null) {
            map.get(n).next = map.get(n.next);
            map.get(n).random = map.get(n.random);
            n = n.next;
        }
        return map.get(head);
    }

    public Node copyRandomList(Node head, Map<Node, Node> map) {
        if (head == null) {
            return null;
        }
        map.putIfAbsent(head, new Node(head.val));
        map.get(head).random = copyRandomList(head.random, map);
        map.get(head).next = copyRandomList(head.next, map);
        return map.get(head);
    }
}
