package com.test.leetcode.page3.chapter200.t203;

import com.test.leetcode.ListNode;

/**
 * @ClassName: OfficialSecond20230219
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/19 18:12
 * @Version: 1.0
 */
public class OfficialSecond20230219 {

    /**
     * 迭代
     * 呃，这写法也是很清爽啊
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode temp = dummyHead;
        while (temp.next != null) {
            if (temp.next.val == val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
        return dummyHead.next;
    }
}
