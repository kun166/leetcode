package com.test.leetcode.page3.chapter200.t203;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20230219
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/19 17:30
 * @Version: 1.0
 */
public class Solution20230219 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dumy = new ListNode();
        ListNode node = dumy;
        while (head != null) {
            if (head.val != val) {
                node.next = head;
                node = head;
            }
            head = head.next;
        }
        // 最后一定别忘了把node的next设置为null
        node.next = null;
        return dumy.next;
    }
}
