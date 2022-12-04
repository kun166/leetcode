package com.test.leetcode.page1.chapter80.t82;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Official20221204
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/4 11:16
 * @Version: 1.0
 */
public class Official20221204 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }
        // 哑变量，这个一般涉及链表都需要定义
        // 注意，这个哑变量的下一个节点是head
        ListNode dummy = new ListNode(0, head);
        // 当前节点
        ListNode cur = dummy;
        // 下一个节点和下下个节点不能为空，为空就跳出循环
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                // 如果节点值有重复
                // 记录当前变量的值
                int x = cur.next.val;
                // 两层循环，如果重复就直接跳过
                while (cur.next != null && cur.next.val == x) {
                    cur.next = cur.next.next;
                }
            } else {
                // 将当前节点设置为下一个节点
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
