package com.test.leetcode.page1.chapter90.t92;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: Solution20221229
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/29 08:24
 * @Version: 1.0
 */
public class Solution20221229 {

    @Test
    public void test() {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(JSON.toJSONString(reverseBetween(head, 2, 4)));
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        right = right - left;
        ListNode dummy = new ListNode();
        ListNode pre = dummy;
        while (left > 1) {
            pre.next = head;
            head = head.next;
            pre = pre.next;
            left--;
        }
        // 现在找到了开始节点
        ListNode tail = head;
        ListNode tailNext = null;
        ListNode curPre = head;
        head = head.next;
        while (right > 0) {
            // 翻转
            tailNext = head.next;
            head.next = curPre;
            curPre = head;
            head = tailNext;
            right--;
        }
        // 现在找到了尾部节点
        pre.next = curPre;
        tail.next = head;
        return dummy.next;
    }
}
