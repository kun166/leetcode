package com.test.leetcode.page2.chapter140.t146;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: OfficialFirst20230203
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/2/3 17:05
 * @Version: 1.0
 */
public class OfficialFirst20230203 {

    class LRUCache extends LinkedHashMap<Integer, Integer> {
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity, 0.75F, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            return super.getOrDefault(key, -1);
        }

        public void put(int key, int value) {
            super.put(key, value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size() > capacity;
        }
    }
}
