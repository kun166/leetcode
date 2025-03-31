package com.test.leetcode.page3.chapter210.t215;

/**
 * @ClassName: Solution2025033101
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/31 11:06
 * @Version: 1.0
 */
public class Solution2025033101 {

    /**
     * 这题想不到好的方式……
     * k个长度的双向链表?
     * <p>
     * 超出时间限制
     *
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        NodeList nodeList = new NodeList(k);
        for (int i : nums) {
            nodeList.add(i);
        }
        return nodeList.tail.pre.val;
    }

    class Node {
        int val;
        Node pre;
        Node next;

        Node(int val) {
            this.val = val;
        }
    }

    class NodeList {
        Node head;
        Node tail;
        int count = 0;
        int maxCount;

        NodeList(int maxCount) {
            head = new Node(Integer.MAX_VALUE);
            tail = new Node(Integer.MIN_VALUE);
            head.next = tail;
            tail.pre = head;
            this.maxCount = maxCount;
        }

        void add(int val) {
            if (count >= maxCount && val <= tail.pre.val) {
                return;
            }
            Node node = tail.pre;
            while (node.val < val) {
                node = node.pre;
            }
            Node newNode = new Node(val);
            newNode.pre = node;
            newNode.next = node.next;
            node.next = newNode;
            newNode.next.pre = newNode;

            if (count == maxCount) {
                // 去掉最后一个元素
                tail.pre.pre.next = tail;
                tail.pre = tail.pre.pre;
            } else {
                count++;
            }
        }
    }
}
