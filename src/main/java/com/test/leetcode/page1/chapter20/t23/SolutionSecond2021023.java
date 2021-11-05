package com.test.leetcode.page1.chapter20.t23;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-23 18:16
 */
public class SolutionSecond2021023 {

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

        ListNode node = mergeKLists(lists);
        while (node != null) {
            System.out.print(node.val);
            node = node.next;
        }
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        int length = lists.length;
        while (length > 1) {
            int index = length / 2;
            //两两合并
            for (int i = 0; i < index; i++) {
                lists[i] = mergeKLists(lists[i * 2], lists[i * 2 + 1]);
            }
            if (index * 2 != length) {
                // 说明还有最后一个没合并。
                lists[index] = lists[length - 1];
                index++;
            }
            for (int i = index; i < length; i++) {
                lists[i] = null;
            }
            length = index;
        }
        return lists[0];
    }

    /**
     * 合并两个队列
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeKLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode root = new ListNode(0);
        ListNode parent = root;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                parent.next = l2;
                parent = parent.next;
                l2 = l2.next;
            } else {
                parent.next = l1;
                parent = parent.next;
                l1 = l1.next;
            }
        }
        parent.next = l1 == null ? l2 : l1;
        return root.next;
    }


    private class ListNode {

        private ListNode next;
        private int val;

        ListNode(int val) {
            this.val = val;
        }

    }
}
