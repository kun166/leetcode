package com.test.leetcode.page2.chapter140.t147;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2021-08-03 09:51
 */
public class Solution {

    @Test
    public void test() {
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        System.out.println(JSON.toJSONString(insertionSortList(head)));
    }

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 先创建一个根节点
        ListNode root = new ListNode();
        root.next = head;
        //当前排序排到的节点的前一个节点
        ListNode indexPre = root;
        // 每次遍历最小的那个节点的前节点
        ListNode minPre = indexPre;

        while (indexPre.next != null) {
            head = indexPre;
            while (head.next != null) {
                if (head.next.val < minPre.next.val) {
                    minPre = head;
                }
                head = head.next;
            }
            //先从原节点中删除
            ListNode min = minPre.next;
            if (min.next != null) {
                minPre.next = min.next;
            } else {
                minPre.next = null;
            }
            // 把min插入到链表中
            min.next = indexPre.next;
            indexPre.next = min;
            //继续下次循环
            indexPre = indexPre.next;
            minPre = indexPre;
        }
        return root.next;
    }
}
