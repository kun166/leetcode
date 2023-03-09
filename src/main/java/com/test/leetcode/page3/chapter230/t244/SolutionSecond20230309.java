package com.test.leetcode.page3.chapter230.t244;

import com.test.leetcode.ListNode;

/**
 * @ClassName: SolutionSecond20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 10:00
 * @Version: 1.0
 */
public class SolutionSecond20230309 {

    public boolean isPalindrome(ListNode head) {
        StringBuilder builder = new StringBuilder();
        while (head != null) {
            builder.append(head.val);
            head = head.next;
        }
        int left = 0, right = builder.length() - 1;
        while (left < right) {
            if (builder.charAt(left) != builder.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
