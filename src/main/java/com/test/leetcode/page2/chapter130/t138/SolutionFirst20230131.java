package com.test.leetcode.page2.chapter130.t138;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution20230131
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/31 10:32
 * @Version: 1.0
 */
public class SolutionFirst20230131 {

    public Node copyRandomList(Node head) {
        // 感觉可以循环遍历两次
        // 第一次遍历，创建对象放到map里面
        // 第二次遍历，补齐
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        Node node = head;
        while (node != null) {
            map.put(node, new Node(node.val));
            node = node.next;
        }
        //补齐
        node = head;
        while (node != null) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
            node = node.next;
        }
        return map.get(head);
    }
}
