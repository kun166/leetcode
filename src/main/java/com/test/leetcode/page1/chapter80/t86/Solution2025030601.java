package com.test.leetcode.page1.chapter80.t86;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: Solution2025030601
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/6 14:25
 * @Version: 1.0
 */
public class Solution2025030601 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(partition(new ListNode(1), 0)));
    }


    /**
     * 这题是个中等题么？感觉像是个简单题？先做下再说
     *
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode firstDummy = new ListNode();
        ListNode first = firstDummy;
        ListNode secondDummy = new ListNode();
        ListNode second = secondDummy;
        while (head != null) {
            if (head.val < x) {
                first.next = head;
                first = first.next;
            } else {
                second.next = head;
                second = second.next;
            }
            head = head.next;
        }
        /**
         * 画蛇添足的写下了如下代码,结果错误
         * if (firstDummy.next == null || secondDummy.next == null)
         *     return head;
         */
        second.next = null;
        first.next = secondDummy.next;
        return firstDummy.next;
    }
}
