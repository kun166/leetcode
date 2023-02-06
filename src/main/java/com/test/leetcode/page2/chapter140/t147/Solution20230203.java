package com.test.leetcode.page2.chapter140.t147;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: Solution20230203
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/3 17:16
 * @Version: 1.0
 */
public class Solution20230203 {

    @Test
    public void test() {
        ListNode head = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        System.out.println(JSON.toJSONString(head));
        System.out.println(JSON.toJSONString(insertionSortList(head)));

    }

    /**
     * 插入排序
     *
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {
        // 链表嘛，先来个伪头部
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode pre = dummy;
        while (pre != null) {
            ListNode p = findMin(pre);
            if (pre == p) {
                break;
            }
            // 把该节点从原来的链表中去掉
            ListNode min = p.next;
            p.next = min.next;
            // 把min加入到已经排好序的链表中
            min.next = pre.next;
            pre.next = min;

            // 继续下一次循环
            pre = pre.next;
        }
        return dummy.next;
    }

    /**
     * 从pre的下一个节点开始找，寻找最小的那个node，返回该node的上一个节点
     *
     * @param pre
     * @return
     */
    public ListNode findMin(ListNode pre) {
        ListNode node = pre;
        while (node.next != null) {
            if (node.next.val < pre.next.val) {
                pre = node;
            }
            // 下一次循环
            node = node.next;
        }
        return pre;
    }
}
