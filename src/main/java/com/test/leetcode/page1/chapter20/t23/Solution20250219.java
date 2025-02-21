package com.test.leetcode.page1.chapter20.t23;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import com.test.leetcode.ListNodeUtil;
import org.junit.Test;

/**
 * @ClassName: Solution20250219
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/2/19 15:52
 * @Version: 1.0
 */
public class Solution20250219 {

    @Test
    public void test() {
        ListNode[] lists = new ListNode[3];
        lists[0] = ListNodeUtil.createListNode(1, 4, 5);
        lists[1] = ListNodeUtil.createListNode(1, 3, 4);
        lists[2] = ListNodeUtil.createListNode(2, 6);
        System.out.println(JSON.toJSONString(mergeKLists(lists)));
    }

    public ListNode mergeKLists(ListNode[] lists) {
        // 两两合并
        if (lists == null || lists.length == 0)
            return null;
        int length = lists.length;
        while (true) {
            if (length == 1) {
                return lists[0];
            }
            for (int i = 0; 2 * i + 1 < length; i++) {
                lists[i] = mergeKLists(lists[2 * i], lists[2 * i + 1]);
            }
            if ((length & 1) != 0) {
                // 奇数个,再合并最后一个
                lists[0] = mergeKLists(lists[0], lists[length - 1]);
            }
            length /= 2;
        }
    }

    /**
     * 两个合并
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeKLists(ListNode l1, ListNode l2) {
        // 两两合并
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode ans = new ListNode();
        ListNode next = ans;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                next.next = l2;
                l2 = l2.next;
            } else {
                next.next = l1;
                l1 = l1.next;
            }
            next = next.next;
        }
        next.next = l1 == null ? l2 : l1;
        return ans.next;
    }
}
