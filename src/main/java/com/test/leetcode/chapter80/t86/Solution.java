package com.test.leetcode.chapter80.t86;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-26 20:19
 */
public class Solution {

    @Test
    public void test() {
        int[] array = new int[]{3, 1, 2};
        ListNode root = new ListNode(0);
        ListNode next = root;
        for (int i : array) {
            next.next = new ListNode(i);
            next = next.next;
        }
        System.out.println(JSON.toJSONString(root.next));
        ListNode head = partition(root.next, 3);
        System.out.println(JSON.toJSONString(head));
    }


    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode root = new ListNode(0);
        ListNode pre = null;
        ListNode more = null;
        if (head.val < x) {
            root.next = head;
        } else {
            pre = root;
            more = head;
        }
        while (head != null && head.next != null) {
            if (more == null && head.next.val >= x) {
                more = head.next;
                pre = head;
            } else if (more != null && head.next.val < x) {
                // 从原来的位置删除掉
                ListNode next = head.next;
                head.next = next.next;

                // 接入到pre后面
                pre.next = next;
                pre = next;
                continue;
            }
            head = head.next;
        }
        if (pre != null)
            pre.next = more;
        return root.next;
    }
}
