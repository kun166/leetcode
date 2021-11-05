package com.test.leetcode.page2.chapter130.t133;

import com.test.leetcode.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-20 15:10
 */
public class Solution {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    public Node cloneGraph(Node node, Map<Integer, Node> map) {
        Node copy = map.get(node.val);
        if (copy == null) {
            copy = new Node(node.val);
            map.put(node.val, copy);
            for (Node n : node.neighbors) {
                copy.neighbors.add(cloneGraph(n, map));
            }
        }
        return copy;
    }
}
