package com.test.leetcode.page1.chapter60.t61;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Official20221116
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/16 19:48
 * @Version: 1.0
 */
public class Official20221116 {
    public ListNode rotateRight(ListNode head, int k) {
        // 这个判断很好，多了一个head.next == null
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        // 这个地方为什么设置n=1?是因为它想循环一边之后，还能拿到最后的那个非空节点
        int n = 1;
        ListNode iter = head;
        while (iter.next != null) {
            iter = iter.next;
            n++;
        }

        // n是链表的长度，然后k%n是循环多次(如果k>n)之后剩余的数，n-k%n是从前面数第几个
        int add = n - k % n;
        if (add == n) {
            return head;
        }

        // 做成环，然后找到要断开的点位
        iter.next = head;
        while (add-- > 0) {
            iter = iter.next;
        }

        // 断开点位
        ListNode ret = iter.next;
        iter.next = null;
        return ret;
    }
}
