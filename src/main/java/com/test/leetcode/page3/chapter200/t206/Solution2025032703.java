package com.test.leetcode.page3.chapter200.t206;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import com.test.leetcode.ListNodeUtil;
import org.junit.Test;

/**
 * @ClassName: Solution2025032701
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/27 14:35
 * @Version: 1.0
 */
public class Solution2025032703 {

    private ListNode ans;

    @Test
    public void test() {
        ListNode node = ListNodeUtil.createListNode(1, 2, 3, 4, 5);
        System.out.println(JSON.toJSONString(node));
        System.out.println(JSON.toJSONString(reverseList(node)));
    }

    /**
     * 递归
     * 如果递归返回尾节点,也即新头节点,则没法递归……
     * <p>
     * 0ms	击败100.00%
     * 41.68MB	击败41.10%
     *
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        back(head).next = null;
        return ans;
    }

    public ListNode back(ListNode head) {
        if (head.next == null) {
            ans = head;
            return head;
        }
        /**
         * 好吧,唉,无语啊,犯了低级错误……
         */
        //back(head).next = head;
        back(head.next).next = head;
        return head;
    }
}
