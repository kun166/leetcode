package com.test.leetcode.page1.chapter10.t19;

import com.test.leetcode.ListNode;

/**
 * 这个确实牛逼啊，思路牛叉
 *
 * @ClassName: SolutionOther20220930
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/9/30 10:35
 * @Version: 1.0
 */
public class SolutionOther20220930 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 这个返回的值，其实是head的长度
        int traverse = traverse(head, n);
        if (traverse == n)
            // n和长度相等，则去掉第一个节点
            return head.next;
        // 否则返回第第一个节点
        return head;
    }

    /**
     * 这个是递归
     *
     * @param node
     * @param n
     * @return
     */
    private int traverse(ListNode node, int n) {
        // 递归的终止条件就是node==null,此时返回的值为0
        if (node == null)
            return 0;
        // 只要node!=null，就递归
        int num = traverse(node.next, n);
        // 如果返回值是n，则将它后面的节点去掉
        if (num == n)
            node.next = node.next.next;
        // 从尾往前加
        return num + 1;
    }
}
