package com.test.leetcode.page3.chapter280.t281;

import java.util.Iterator;
import java.util.List;

/**
 * @ClassName: Solution20230330
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/3/30 09:53
 * @Version: 1.0
 */
public class Solution20230330 {

    /**
     * 执行用时：1 ms, 在所有 Java 提交中击败了100.00%的用户
     * 内存消耗：42.2 MB, 在所有 Java 提交中击败了50.41%的用户
     * 通过测试用例：124 / 124
     */
    public class ZigzagIterator {

        private int index;

        Iterator<Integer> i1;
        Iterator<Integer> i2;

        public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
            i1 = v1.iterator();
            i2 = v2.iterator();
            index = -1;
        }

        public int next() {
            index++;
            if (index % 2 == 0) {
                if (i1.hasNext())
                    return i1.next();
                return i2.next();
            } else {
                if (i2.hasNext())
                    return i2.next();
                return i1.next();
            }
        }

        public boolean hasNext() {
            return i1.hasNext() || i2.hasNext();
        }
    }
}
