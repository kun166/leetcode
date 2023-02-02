package com.test.leetcode.page2.chapter140.t143;

import com.test.leetcode.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230202
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/2 10:17
 * @Version: 1.0
 */
public class SolutionFirst20230202 {


    /**
     * 来个无脑的吧
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int length = list.size() >> 1;
        ListNode h, t;
        for (int i = 0; i < length; i++) {
            h = list.get(i);
            t = list.get(list.size() - 1 - i);
            t.next = h.next;
            h.next = t;
        }
        // 最后那个节点的next置为null
        list.get(length).next = null;
    }
}
