package com.test.leetcode.page2.chapter160.t160;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: Solution20230208
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/8 11:23
 * @Version: 1.0
 */
public class Solution20230208 {

    @Test
    public void test() {
        ListNode headA = new ListNode(3);
        ListNode headB = new ListNode(2, headA);
        System.out.println(JSON.toJSONString(getIntersectionNode(headA, headB)));
    }

    /**
     * 呃，我承认，我看官方题解了，妙啊。看了官方解答，这个代码也是错误的，我想哭
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA, nodeB = headB;
        while (true) {
            if (nodeA == nodeB) {
                return nodeA;
            }
            if (nodeA == null) {
                nodeA = headB;
            }
            if (nodeB == null) {
                nodeB = headA;
            }
            nodeA = nodeA.next;
            nodeB = nodeB.next;

        }
    }
}
