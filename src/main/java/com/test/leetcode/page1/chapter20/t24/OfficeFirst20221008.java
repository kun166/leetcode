package com.test.leetcode.page1.chapter20.t24;

import com.test.leetcode.ListNode;

/**
 * @ClassName: OfficeFirst20221008
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/8 15:07
 * @Version: 1.0
 */
public class OfficeFirst20221008 {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            // 递归终止条件
            // 当前节点为空，或者当前节点的下一个节点为空，则返回当前节点
            return head;
        }
        // 下面就是将head和head的next交换
        // 将head的next记录一下，它将成为新的第一个节点
        ListNode newHead = head.next;
        // head将成为新的第二个节点
        head.next = swapPairs(newHead.next);
        // 建立新的第一个节点和新的第二个节点的关联关系
        newHead.next = head;
        // 返回新的第一个节点
        return newHead;
    }
}
