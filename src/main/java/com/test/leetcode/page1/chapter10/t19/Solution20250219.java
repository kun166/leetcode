package com.test.leetcode.page1.chapter10.t19;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20250219
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/19 11:21
 * @Version: 1.0
 */
public class Solution20250219 {


    /**
     * 进阶的遍历一遍,除非用Map或者数组以空间换时间……
     * 先来遍历两遍的算法吧
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode root = new ListNode();
        root.next = head;
        int length = 1;
        while (head.next != null) {
            length++;
            head = head.next;
        }
        // 删除的位置即为 length - n;
        length = length - n;
        head = root;
        while (length > 0) {
            head = head.next;
            length--;
        }
        head.next = head.next.next;
        return root.next;
    }

}
