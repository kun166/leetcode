package com.test.leetcode.page3.chapter230.t237;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Official20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 15:58
 * @Version: 1.0
 */
public class Official20230309 {

    /**
     * 呃，跪了，跪了
     *
     * @param node
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
