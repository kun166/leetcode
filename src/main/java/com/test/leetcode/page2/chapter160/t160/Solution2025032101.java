package com.test.leetcode.page2.chapter160.t160;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025032101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/21 17:51
 * @Version: 1.0
 */
public class Solution2025032101 {

    /**
     * 嗯嗯,这道题有印象啊……记得第一次做没做出来
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode first = headA;
        ListNode second = headB;
        while (first != second) {
            first = first.next;
            second = second.next;
            if (first == null && first != second) {
                /**
                 * 如果headA和headB相交,且长度一样,走不到first == null&&second==null
                 * 否则,first走到终点的时候,second肯定不到终点
                 */
                first = headB;
            }
            if (second == null && second != first) {
                second = headA;
            }
        }
        return first;
    }
}
