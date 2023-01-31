package com.test.leetcode.page2.chapter130.t138;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: SolutionSecond20230131
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/31 10:43
 * @Version: 1.0
 */
public class SolutionSecond20230131 {

    /**
     * 来一个递归吧
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        return copyRandomList(head, new HashMap<>());
    }

    public Node copyRandomList(Node head, Map<Node, Node> map) {
        if (head == null) {
            return null;
        }
        Node node = map.get(head);
        if (node == null) {
            node = new Node(head.val);
            map.put(head, node);
            node.next = copyRandomList(head.next, map);
            node.random = copyRandomList(head.random, map);
        }
        return node;
    }
}
