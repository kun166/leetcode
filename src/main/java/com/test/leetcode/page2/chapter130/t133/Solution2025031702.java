package com.test.leetcode.page2.chapter130.t133;

import com.test.leetcode.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: Solution2025031702
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/17 09:52
 * @Version: 1.0
 */
public class Solution2025031702 {

    /**
     * 26ms	击败42.27%
     * 41.89MB	击败88.63%
     *
     * @param node
     * @return
     */
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        LinkedList<Node> ll = new LinkedList();
        ll.push(node);
        Map<Integer, Node> map = new HashMap<>();

        // 1,只创建节点
        while (!ll.isEmpty()) {
            Node old = ll.pop();
            if (!map.containsKey(old.val)) {
                map.put(old.val, new Node(old.val));
                for (Node nl : old.neighbors) {
                    if (!map.containsKey(nl.val)) {
                        ll.push(nl);
                    }
                    map.get(old.val).neighbors.add(nl);
                }
            }
        }

        // 2,复制neighbors
        for (Node newNode : map.values()) {
            for (int i = 0; i < newNode.neighbors.size(); i++) {
                newNode.neighbors.set(i, map.get(newNode.neighbors.get(i).val));
            }
        }
        return map.get(node.val);
    }
}
