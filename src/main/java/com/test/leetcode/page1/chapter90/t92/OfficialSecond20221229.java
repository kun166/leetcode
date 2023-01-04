package com.test.leetcode.page1.chapter90.t92;

import com.test.leetcode.ListNode;

/**
 * @ClassName: OfficialSecond20221229
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/29 08:58
 * @Version: 1.0
 */
public class OfficialSecond20221229 {

    /**
     * 方法二：一次遍历「穿针引线」反转链表（头插法）
     * 这个解法，不是翻转，而是插入。
     * 例如：9->7->2->5->4->3->6
     * 2->5->4->3需要翻转
     * 1,先将5插入到2的前面
     * 2,将4插入到5的前面
     * 3,将3插入到4的前面
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 设置 dummyNode 是这一类问题的一般做法
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }
}
