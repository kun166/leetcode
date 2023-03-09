package com.test.leetcode.page3.chapter230.t244;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 09:55
 * @Version: 1.0
 */
public class SolutionFirst20230309 {

    public boolean isPalindrome(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            head = head.next;
        }
        return builder.toString().equals(builder.reverse().toString());
    }
}
