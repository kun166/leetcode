package com.test.leetcode.page3.chapter200.t203;


import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 08:35
 * @Version: 1.0
 */
public class Solution2025032701 {

    /**
     * 这个简单题,也需要注意好多地方
     * 0ms	击败100.00%
     * 44.70MB	击败45.51%
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head);
        ListNode pre = dummy;
        /**
         * 这个地方不需要判断pre!=null
         */
        while (pre.next != null) {
            if (pre.next.val == val) {
                pre.next = pre.next.next;
            } else {
                /**
                 * 这个地方是一个else,而不是去掉
                 */
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
