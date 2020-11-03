package com.test.leetcode.chapter20.t25;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-10-26 11:25
 */
public class Solution20201026 {

    @Test
    public void test() {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(3);
        l1.next.next.next = new ListNode(4);
        l1.next.next.next.next = new ListNode(5);

        l1 = reverseKGroup(l1, 3);

        while (l1 != null) {
            System.out.print(l1.val);
            l1 = l1.next;
        }
    }


    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1 || head == null) return head;
        ListNode loop;
        ListNode pre = null;
        ListNode root = null;
        ListNode start = head;
        do {
            loop = null;
            int times = k;
            ListNode end = start;
            //找出开始和结束的。
            while (times > 1 && end.next != null) {
                end = end.next;
                times--;
            }
            if (times == 1) {
                //反转。开始的是start,结束的是end
                // 先暂存end的下一个节点。
                loop = end.next;
                // 进行反转。
                reverse(start, end);
                //记录返回点。反转之后连接以前的节点。
                if (pre == null)
                    root = end;
                else
                    pre.next = end;
                // 进行下一次循环；
                pre = start;
                start = loop;
            } else {
                // 说明不够k个元素。直接结束？
                if (pre == null)
                    root = head;
                else
                    pre.next = start;
            }
        } while (loop != null);


        return root;
    }

    /**
     * 反转
     *
     * @param node
     */
    public ListNode reverse(ListNode node, ListNode end) {
        ListNode pre = null;
        while (node != end) {
            // 保存下一个节点
            ListNode next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        end.next = pre;
        return end;
    }

    private class ListNode {

        private ListNode next;
        private int val;

        ListNode(int val) {
            this.val = val;
        }

    }
}
