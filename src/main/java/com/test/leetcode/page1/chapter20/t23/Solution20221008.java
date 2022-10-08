package com.test.leetcode.page1.chapter20.t23;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: Solution20221008
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/10/8 10:38
 * @Version: 1.0
 */
public class Solution20221008 {

    @Test
    public void test() {
        ListNode[] lists = new ListNode[3];
        lists[0] = new ListNode(1);
        lists[0].next = new ListNode(4);
        lists[0].next.next = new ListNode(5);

        lists[1] = new ListNode(1);
        lists[1].next = new ListNode(3);
        lists[1].next.next = new ListNode(4);

        lists[2] = new ListNode(2);
        lists[2].next = new ListNode(6);

        System.out.println(JSON.toJSONString(mergeKLists(lists)));

    }

    public ListNode mergeKLists(ListNode[] lists) {
        int length = lists.length;
        while (length > 1) {
            int size = length / 2;
            int doubleSize = length % 2 == 0 ? 0 : 1;
            for (int i = 0; i < size; i++) {
                lists[i] = mergeListNode(lists[i], lists[i + size + doubleSize]);
            }
            length = size + doubleSize;
        }
        return lists.length > 0 ? lists[0] : null;
    }

    /**
     * 合并两个链表
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeListNode(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode root = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                root.next = l2;
                l2 = l2.next;
            } else {
                root.next = l1;
                l1 = l1.next;
            }
            root = root.next;
        }
        root.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
