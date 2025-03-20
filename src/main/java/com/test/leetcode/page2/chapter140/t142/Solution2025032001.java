package com.test.leetcode.page2.chapter140.t142;

import com.test.leetcode.ListNode;

/**
 * @ClassName: Solution2025032001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 11:23
 * @Version: 1.0
 */
public class Solution2025032001 {

    /**
     * 其实不会做,这是百度了之后写出来的代码
     * 0ms	击败100.00%
     * 43.53MB	击败95.25%
     * <p>
     * 解题思路:
     * 快慢指针:
     * 1,快指针每次走两步,慢指针每次走1步
     * 2,快指针到头了,说明没有环
     * 下面是有环的情况:
     * 3,快慢指针相遇了,即==,说明有环
     * 4,此时快指针不动,慢指针从head开始,快慢指针都是每次走一步
     * 5,相遇的那个节点即为环的首节点
     * 证明:
     * 1,假设环的长度是b,环外的长度是a
     * 2,第一次相遇时,离环首的距离为c,慢指针走了m圈,快指针走了n圈
     * 3,更确切的说慢指针走了0,即m==0。
     * 当慢指针进入环首节点的时候,不论快指针在环的哪个位置,快慢指针的差距都小于一个环的长度,
     * 慢指针每走一步,快指针就会追赶一步。
     * 4,第一次相遇时,慢指针走过的距离a+c,快指针走过的距离a+c+n*b
     * 5,快指针走的步数是慢指针的2倍:2(a+c)=a+c+n*b;整理得到:c=n*b-a
     * 6,此时快指针每次走一步,走a步即可到环的末尾,a+1步即可到环的首节点。
     * 7,怎么走a步?慢指针重新从head走到环的首节点是a+1步
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                // 有环
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        // 没有环
        return null;
    }
}
