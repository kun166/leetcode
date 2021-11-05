package com.test.leetcode.page1.chapter70.t77;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-12 15:17
 */
public class Solution {

    @Test
    public void test() {
        List<List<Integer>> list = combine(4, 2);
        System.out.println(JSON.toJSONString(list));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (k > n)
            return ans;
        LinkedList<Integer> list = new LinkedList<>();
        combine(ans, list, n, k, 1);
        return ans;
    }

    public void combine(List<List<Integer>> ans, LinkedList<Integer> list, int n, int k, int index) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (n - index + 1 < k - list.size())
            return;
        for (int i = index; i <= n; i++) {
            list.add(i);
            combine(ans, list, n, k, i + 1);
            list.removeLast();
        }
    }
}
