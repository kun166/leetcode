package com.test.leetcode.page1.chapter80.t82;

import com.alibaba.fastjson.JSON;
import com.test.leetcode.ListNode;
import org.junit.Test;

/**
 * @ClassName: Solution20221202
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/12/2 7:33
 * @Version: 1.0
 */
public class Solution20221202 {

    @Test
    public void test() {
        //ListNode root = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        ListNode root = new ListNode(1, new ListNode(1));
        System.out.println(JSON.toJSONString(root));
        root = deleteDuplicates(root);
        System.out.println(JSON.toJSONString(root));
    }

    /**
     * 1，已经排好序
     * 2，删除重复项目
     * 3，设置一个虚拟点
     * 4，下一个节点重复略过，不重复就把添加
     * 5，返回虚拟点的下一个节点
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode root = new ListNode();
        ListNode parent = root;
        boolean repeat = false;
        while (head.next != null) {
            if (head.val != head.next.val) {
                if (!repeat) {
                    parent.next = head;
                    parent = head;
                }
                repeat = false;
            } else {
                // 略过这个节点啊
                repeat = true;
            }
            head = head.next;
        }
        // 最后这个节点不好处理
        if (!repeat) {
            parent.next = head;
        } else {
            parent.next = null;
        }
        return root.next;
    }
}
