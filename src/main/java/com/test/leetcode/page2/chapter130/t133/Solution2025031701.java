package com.test.leetcode.page2.chapter130.t133;

import com.test.leetcode.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @ClassName: Solution2025031701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/17 09:23
 * @Version: 1.0
 */
public class Solution2025031701 {

    /**
     * 不知道考察的啥,空间换时间?
     * <p>
     * 呃，超出时间限制……这是死循环了……
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
        // 1,只创建节点,不复制neighbors
        while (!ll.isEmpty()) {
            Node old = ll.pop();
            if (!map.containsKey(old.val)) {
                map.put(old.val, new Node(old.val));
            }
            for (Node nl : old.neighbors) {
                ll.push(nl);
            }
        }

        // 2,复制neighbors?
        ll.push(node);
        while (!ll.isEmpty()) {
            Node old = ll.pop();
            for (Node nl : old.neighbors) {
                map.get(old.val).neighbors.add(map.get(nl.val));
                ll.push(nl);
            }
        }
        return map.get(node.val);
    }
}
