package com.test.leetcode.page3.chapter280.t284;

import java.util.Iterator;

/**
 * @ClassName: Solution20230331
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/31 09:03
 * @Version: 1.0
 */
public class Solution20230331 {

    /**
     * 执行用时：4 ms, 在所有 Java 提交中击败了79.33%的用户
     * 内存消耗：41.6 MB, 在所有 Java 提交中击败了11.85%的用户
     * 通过测试用例：14 / 14
     */
    class PeekingIterator implements Iterator<Integer> {

        private Iterator<Integer> iterator;
        private boolean hasPeek = false;
        private int peekValue;


        public PeekingIterator(Iterator<Integer> iterator) {
            // initialize any member here.
            this.iterator = iterator;
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            if (hasPeek) {
                return peekValue;
            }
            hasPeek = true;
            peekValue = iterator.next();
            return peekValue;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            if (hasPeek) {
                hasPeek = false;
                return peekValue;
            }
            return iterator.next();
        }

        @Override
        public boolean hasNext() {
            if (hasPeek) {
                return true;
            }
            return iterator.hasNext();
        }
    }
}
