package com.test.leetcode.page1.chapter20.t21;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-16 20:19
 */
public class Solution {

    @Test
    public void test() {
        LinkedNode n1 = new LinkedNode(1);
        n1.next = new LinkedNode(2);
        n1.next.next = new LinkedNode(4);

        LinkedNode n2 = new LinkedNode(1);
        n2.next = new LinkedNode(3);
        n2.next.next = new LinkedNode(4);

        LinkedNode result = merge(n1, n2);
        while (result != null) {
            System.out.print(result.value);
            System.out.print("->");
            result = result.next;
        }
    }

    public LinkedNode merge(LinkedNode n1, LinkedNode n2) {
        LinkedNode result = new LinkedNode(0);
        LinkedNode cn = result;
        while (n1 != null || n2 != null) {
            int v1 = n1 == null ? Integer.MAX_VALUE : n1.value;
            int v2 = n2 == null ? Integer.MAX_VALUE : n2.value;
            cn.next = new LinkedNode(Math.min(v1, v2));
            cn = cn.next;
            if (v1 <= v2 && n1 != null) {
                n1 = n1.next;
            } else {
                n2 = n2.next;
            }
        }
        return result.next;
    }

    private static class LinkedNode {
        private int value;
        private LinkedNode next;

        LinkedNode(int value) {
            this.value = value;
        }
    }
}
