package com.test.leetcode.page2.chapter140.t146;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: LRUCache20230203
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/3 10:18
 * @Version: 1.0
 */
public class LRUCache20230203 {

    @Test
    public void test() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));
        cache.put(4, 4);
        System.out.println(cache.get(1));
        System.out.println(cache.get(3));
        System.out.println(cache.get(4));

    }

    class LRUCache {

        Map<Integer, Cache> map;
        Cache head;
        Cache tail;
        int capacity;
        int size;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.size = 0;
            map = new HashMap<>();
            head = new Cache(0, 0);
            tail = new Cache(0, 0);
            head.next = tail;
            tail.pre = head;
        }

        public int get(int key) {
            Cache cache = map.get(key);
            if (cache == null) {
                return -1;
            }
            // 转换位置
            index(cache);
            return cache.value;
        }

        public void put(int key, int value) {
            Cache cache = map.get(key);
            if (cache != null) {
                index(cache);
                cache.value = value;
                return;
            }
            // 判断是不是超过容量
            if (size < capacity) {
                // 插入首节点
                cache = new Cache(key, value);
                index(cache);
                size++;
            } else {
                // 删除最后一个节点
                map.remove(tail.pre.key);
                Cache pre = tail.pre.pre;
                pre.next = tail;
                tail.pre = pre;

                // 插入首节点
                cache = new Cache(key, value);
                index(cache);
            }
            map.put(key, cache);
        }

        void index(Cache cache) {
            if (cache.pre != null) {
                // 说明已经存在了，只是调整位置
                // 调整位置
                Cache pre = cache.pre;
                Cache next = cache.next;
                pre.next = next;
                next.pre = pre;
            }
            // 插入首节点的下一个节点
            Cache next = head.next;
            head.next = cache;
            cache.next = next;
            cache.pre = head;
            next.pre = cache;
        }


    }

    class Cache {
        int key;
        int value;
        Cache next;
        Cache pre;

        Cache(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
