package com.test.leetcode.page2.chapter140.t143;

import com.test.leetcode.ListNode;

import java.util.List;

/**
 * @ClassName: SolutionSecond20230202
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/2 10:44
 * @Version: 1.0
 */
public class SolutionSecond20230202 {

    /**
     * 呃，这个方法确实没想到啊……，居然可以这么搞
     *
     * @param head
     */
    public void reorderList(ListNode head) {
        int length = 0;
        // 初始化链表总长度
        ListNode node = head;
        while (node != null) {
            node = node.next;
            length++;
        }
        if (length <= 2) {
            return;
        }
        // 找出中间数目
        int mid = length - (length >> 1);
        // 找到上半部分的结尾
        ListNode halfTail = head;
        while (mid > 1) {
            //第一次运行的时候，这个地方出了问题。>0是不对的，得需要>1
            halfTail = halfTail.next;
            mid--;
        }
        ListNode secondHead = halfTail.next;
        halfTail.next = null;
        // 对下半部分进行翻转
        secondHead = flip(secondHead);
        // 合并
        while (secondHead != null) {
            ListNode firstNext = head.next;
            ListNode secondNext = secondHead.next;
            head.next = secondHead;
            secondHead.next = firstNext;
            head = firstNext;
            secondHead = secondNext;
        }

    }

    public ListNode flip(ListNode head) {
        ListNode pre = null;
        while (head.next != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        // 第一次运行，这个地方漏了，导致翻转后的链表，只存在最后一个节点了
        head.next = pre;
        return head;
    }
}
