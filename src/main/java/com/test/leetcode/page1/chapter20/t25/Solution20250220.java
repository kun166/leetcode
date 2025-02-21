package com.test.leetcode.page1.chapter20.t25;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import com.test.leetcode.ListNodeUtil;
import org.junit.Test;

/**
 * @ClassName: Solution20250220
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/20 09:30
 * @Version: 1.0
 */
public class Solution20250220 {

    @Test
    public void test() {
        ListNode head = ListNodeUtil.createListNode(1, 2, 3, 4, 5);
        System.out.println(JSON.toJSONString(reverseKGroup(head, 3)));
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode ans = new ListNode();
        ListNode pre = ans;
        ListNode tail = getTail(head, k);
        while (tail != null && tail != head) {
            // 翻转
            // 尾部的下一个，记录下来，用作下一次循环的head
            ListNode next = tail.next;
            pre.next = reverse(head, tail);
            pre = head;
            head = next;
            tail = getTail(head, k);
        }
        pre.next = tail;
        return ans.next;

    }

    /**
     * 获取第K个节点，如果不够K个节点，则返回首节点
     *
     * @param head
     * @param k
     * @return
     */
    public ListNode getTail(ListNode head, int k) {
        if (head == null || head.next == null)
            return head;
        ListNode root = head;
        while (k > 1 && head.next != null) {
            head = head.next;
            k--;
        }
        return k == 1 ? head : root;
    }

    public ListNode reverse(ListNode head, ListNode tail) {
        ListNode pre = null, next;
        while (head != tail) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        head.next = pre;
        return head;
    }

}
