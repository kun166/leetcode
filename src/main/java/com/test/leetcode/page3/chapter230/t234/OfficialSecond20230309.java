package com.test.leetcode.page3.chapter230.t234;

import com.test.leetcode.ListNode;

/**
 * @ClassName: OfficialSecond20230309
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/9 10:37
 * @Version: 1.0
 */
public class OfficialSecond20230309 {

    private ListNode frontPointer;

    /**
     * 方法二：递归
     * <p>
     * 递归这个真没想到
     *
     * @param currentNode
     * @return
     */
    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val) {
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

}
