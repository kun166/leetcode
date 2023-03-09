package com.test.leetcode.page3.chapter230.t237;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 15:49
 * @Version: 1.0
 */
public class Solution20230309 {

    public void deleteNode(ListNode node) {
        // node.next.next==null,则node.next是最后一个节点啊
        while (node.next.next != null) {
            node.val = node.next.val;
            node = node.next;
        }
        node.val = node.next.val;
        node.next = null;
    }
}
