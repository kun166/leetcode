package com.test.leetcode.page2.chapter130.t138;

/**
 * @ClassName: OfficialSecond20230131
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/31 11:29
 * @Version: 1.0
 */
public class OfficialSecond20230131 {


    /**
     * 这个算法，很牛
     * A->A(新)->B->B(新)->C->C(新)
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // 因为将新旧节点连起来了，所以需要node = node.next.next
        for (Node node = head; node != null; node = node.next.next) {
            // 创建新节点，并且把新节点加入到纠结点之后
            Node nodeNew = new Node(node.val);
            nodeNew.next = node.next;
            node.next = nodeNew;
        }
        for (Node node = head; node != null; node = node.next.next) {
            Node nodeNew = node.next;
            // 这……牛逼plus啊
            nodeNew.random = (node.random != null) ? node.random.next : null;
        }
        Node headNew = head.next;
        for (Node node = head; node != null; node = node.next) {
            // 还原原来的节点链表
            // 重建现在的节点链表
            // 拿到新的节点
            Node nodeNew = node.next;
            // 不影响新的节点的next.next是下一个新的节点
            node.next = node.next.next;
            // 重组新节点链表
            nodeNew.next = (nodeNew.next != null) ? nodeNew.next.next : null;
        }
        return headNew;
    }
}
