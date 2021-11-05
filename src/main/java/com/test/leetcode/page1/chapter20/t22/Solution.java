package com.test.leetcode.page1.chapter20.t22;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: study
 * @description:
 * @author: qinfajia
 * @create: 2020-09-17 09:53
 */
public class Solution {

    @Test
    public void test() {
        List<StringBuilder> list = createBracket(3);
        for (StringBuilder builder : list) {
            System.out.println(builder.toString());
        }

    }

    public List<StringBuilder> createBracket(int n) {
        List<StringBuilder> list = new ArrayList<>();
        if (n == 1) {
            list.add(new StringBuilder("()"));
        } else if (n == 2) {
            list.add(new StringBuilder("()()"));
            list.add(new StringBuilder("(())"));
        } else {
            List<StringBuilder> preList = createBracket(n - 1);
            for (StringBuilder builder : preList) {
                StringBuilder b = new StringBuilder();
                b.append("(").append(builder).append(")");
                list.add(b);
                StringBuilder left = new StringBuilder("()").append(builder);
                list.add(left);
                StringBuilder right = new StringBuilder(builder).append("()");
                if (!left.toString().equals(right.toString())) {
                    list.add(right);
                }
            }
        }
        return list;
    }
}
