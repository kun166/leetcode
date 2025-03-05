package com.test.leetcode.page1.chapter80.t83;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import com.test.leetcode.ListNodeUtil;
import org.junit.Test;

/**
 * @ClassName: Solution2025030501
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/5 15:00
 * @Version: 1.0
 */
public class Solution2025030501 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(deleteDuplicates(ListNodeUtil.createListNode(1, 1, 1))));
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val)
                cur.next = cur.next.next;
            else {
                /**
                 * 不加else就等着错吧
                 */
                cur = cur.next;
            }
        }
        return head;
    }
}
