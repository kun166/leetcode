package com.test.leetcode.page2.chapter130.t133;

import com.test.leetcode.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20230129
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/29 15:57
 * @Version: 1.0
 */
public class Solution20230129 {

    /**
     * 感觉可以用递归……
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        // 这种声明的map，确实不如 Map<Node, Node> map = new HashMap() 更好一些
        Map<Integer, Node> map = new HashMap();
        return cloneGraph(node, map);
    }

    public Node cloneGraph(Node node, Map<Integer, Node> map) {
        // 递归到map中有该node就结束，说明已经创建过了
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }

        Node nodeCopy = new Node(node.val, new ArrayList<>());
        map.put(node.val, nodeCopy);
        for (Node n : node.neighbors) {
            nodeCopy.neighbors.add(cloneGraph(n, map));
        }
        return nodeCopy;
    }
}

