package com.test.leetcode.page5.chapter430.t430;

/**
 * @ClassName: OfficialFirst20230606
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/6 08:41
 * @Version: 1.0
 */
public class OtherFirst20230606 {

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        while (head != null) {
            // 有子节点，没有子节点，根据这两种情况分别处理
            if (head.child == null) {
                head = head.next;
            } else {
                Node tmp = head.next;
                Node chead = flatten(head.child);
                head.next = chead;
                chead.prev = head;
                head.child = null;
                while (head.next != null) head = head.next;
                head.next = tmp;
                if (tmp != null) tmp.prev = head;
                head = tmp;
            }
        }
        return dummy.next;
    }

}
