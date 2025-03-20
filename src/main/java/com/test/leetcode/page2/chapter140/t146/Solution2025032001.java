package com.test.leetcode.page2.chapter140.t146;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Solution2025032001
 * @Description:
 * @Author: qinfajia
 * @Date: 2025/3/20 17:26
 * @Version: 1.0
 */
public class Solution2025032001 {

    class LRUCache {
        int capacity;
        int size;
        Map<Integer, ListNode> map;
        ListNode head;
        ListNode tail;

        /**
         * 呃，感觉得用链表啊……
         * 需要注意的是,put也改变链表位置
         *
         * @param capacity
         */
        public LRUCache(int capacity) {
            this.capacity = capacity;
            map = new HashMap<>();
            head = new ListNode(0, 0);
            tail = new ListNode(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            ListNode node = map.get(key);
            if (node != null) {
                remove(node);
                add(node);
            }
            return node == null ? -1 : node.val;
        }

        public void put(int key, int value) {
            ListNode node = map.get(key);
            if (node == null) {
                node = new ListNode(value, key);
                if (size < capacity) {
                    add(node);
                    size++;
                } else {
                    remove(tail.pre);
                    add(node);
                }
            } else {
                node.val = value;
                remove(node);
                add(node);
            }
        }

        void remove(ListNode node) {
            ListNode pre = node.pre;
            ListNode next = node.next;
            pre.next = next;
            next.pre = pre;
            map.remove(node.key);
        }

        void add(ListNode node) {
            ListNode next = head.next;
            head.next = node;
            node.next = next;
            node.pre = head;
            next.pre = node;
            map.put(node.key, node);
        }

        class ListNode {

            public int val;
            public int key;
            public ListNode next;
            public ListNode pre;

            public ListNode(int val, int key) {
                this.val = val;
                this.key = key;
            }
        }
    }
}
