package com.test.leetcode.page5.chapter430.t430;

/**
 * @ClassName: OtherThird20230606
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/6/6 08:52
 * @Version: 1.0
 */
public class OtherThird20230606 {

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public Node flatten(Node head) {
        Node dummy = new Node();
        dummy.next = head;
        for (; head != null; head = head.next) {
            if (head.child != null) {
                Node tmp = head.next;
                Node child = head.child;
                head.next = child;
                child.prev = head;
                head.child = null;
                Node last = head;
                while (last.next != null) last = last.next;
                last.next = tmp;
                if (tmp != null) tmp.prev = last;
            }
        }
        return dummy.next;
    }
}
