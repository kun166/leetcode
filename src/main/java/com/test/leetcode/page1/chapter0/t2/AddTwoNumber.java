package com.test.leetcode.page1.chapter0.t2;

import org.junit.Test;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-09 19:52
 */
public class AddTwoNumber {

    @Test
    public void test() {
        ListNode<Integer> f = new ListNode<Integer>(2);
        f.next = new ListNode<Integer>(4);
        f.next.next = new ListNode<Integer>(3);

        ListNode<Integer> s = new ListNode<Integer>(5);
        s.next = new ListNode<Integer>(6);
        s.next.next = new ListNode<Integer>(4);
        s.next.next.next = new ListNode<Integer>(9);

        ListNode<Integer> result = addTwoNumber(f, s);
        while (result != null) {
            System.out.print(result.value);
            System.out.print("->");
            result = result.next;
        }

    }


    public ListNode<Integer> addTwoNumber(ListNode<Integer> first, ListNode<Integer> second) {
        ListNode<Integer> result = new ListNode(0);
        ListNode<Integer> current = result;
        int more = 0;
        while (first != null || second != null) {
            int sum = (first == null ? 0 : first.value) + (second == null ? 0 : second.value) + more;
            more = sum > 9 ? 1 : 0;
            sum = sum > 9 ? sum - 10 : sum;
            current.next = new ListNode(sum);
            current = current.next;
            if (first != null) first = first.next;
            if (second != null) second = second.next;
        }

        if (more > 0) {
            current.next = new ListNode(more);
        }
        return result.next;
    }

    private static class ListNode<T> {
        T value;
        ListNode<T> next;

        ListNode(T value) {
            this.value = value;
        }
    }
}
