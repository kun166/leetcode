package com.test.leetcode.page3.chapter200.t203;

import com.test.leetcode.ListNode;

/**
 * @ClassName: OfficialFirst20230219
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/19 17:37
 * @Version: 1.0
 */
public class OfficialFirst20230219 {

    /**
     * 递归啊……
     * 这个确实没想过
     * 对递归还是不够熟悉
     * <p>
     * 递归的精髓
     * 1.明确递归终止条件；
     * 2.给出递归终止时的处理办法；
     * 3.提取重复的逻辑，缩小问题规模。
     *
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}
