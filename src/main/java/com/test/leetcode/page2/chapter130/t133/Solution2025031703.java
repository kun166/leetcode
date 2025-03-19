package com.test.leetcode.page2.chapter130.t133;

import com.test.leetcode.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: Solution2025031703
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/17 10:10
 * @Version: 1.0
 */
public class Solution2025031703 {

    /**
     * 递归？
     * 36ms	击败5.55%
     * 41.92MB	击败79.54%
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Integer, Node> map = new HashMap<>();
        return cloneGraph(node, map);
    }

    public Node cloneGraph(Node node, Map<Integer, Node> map) {
        if (!map.containsKey(node.val)) {
            map.put(node.val, new Node(node.val));
            for (Node n : node.neighbors) {
                map.get(node.val).neighbors.add(cloneGraph(n, map));
            }
        }
        return map.get(node.val);
    }
}
