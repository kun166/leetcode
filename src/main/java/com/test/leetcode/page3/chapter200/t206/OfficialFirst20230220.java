package com.test.leetcode.page3.chapter200.t206;

import com.test.leetcode.ListNode;

/**
 * @ClassName: OfficialFirst20230220
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/20 10:18
 * @Version: 1.0
 */
public class OfficialFirst20230220 {

    /**
     * 迭代
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        /**
         * 牛逼,唉,唉,代码写的是真简洁
         */
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

}
