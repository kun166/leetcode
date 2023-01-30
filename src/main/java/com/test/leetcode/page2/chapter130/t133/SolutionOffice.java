package com.test.leetcode.page2.chapter130.t133;

import com.test.leetcode.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 广度优先算法
 *
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-07-20 15:37
 */
public class SolutionOffice {

    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }

        // 记录是否已经创建过
        HashMap<Node, Node> visited = new HashMap();

        // 将题目给定的节点添加到队列
        // 广度优先的精髓其实就是这个队列啊，一定一定要记住
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(node);
        // 克隆第一个节点并存储到哈希表中
        visited.put(node, new Node(node.val, new ArrayList()));

        // 广度优先搜索
        while (!queue.isEmpty()) {
            // 取出队列的头节点
            Node n = queue.remove();
            // 遍历该节点的邻居
            for (Node neighbor : n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    // 如果没有被访问过，就克隆并存储在哈希表中
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    // 将邻居节点加入队列中
                    queue.add(neighbor);
                }
                // 更新当前节点的邻居列表
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}
