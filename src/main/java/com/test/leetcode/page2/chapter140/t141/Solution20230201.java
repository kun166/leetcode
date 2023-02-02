package com.test.leetcode.page2.chapter140.t141;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20230201
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/1 17:39
 * @Version: 1.0
 */
public class Solution20230201 {
    public boolean hasCycle(ListNode head) {
        ListNode twoStep = head;
        while (head != null && twoStep != null) {
            head = head.next;
            twoStep = twoStep.next;
            if (twoStep != null) {
                twoStep = twoStep.next;
                if (head == twoStep) {
                    return true;
                }
            }
        }
        return false;
    }
}
