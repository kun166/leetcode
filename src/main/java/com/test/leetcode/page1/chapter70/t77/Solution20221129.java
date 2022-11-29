package com.test.leetcode.page1.chapter70.t77;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20221129
 * @Description:
 * @Author: qinfajia
 * @Date: 2022/11/29 20:30
 * @Version: 1.0
 */
public class Solution20221129 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(combine(1, 1)));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        combine(n, k, ans, new ArrayList<>(), 1);
        return ans;
    }

    public void combine(int n, int k, List<List<Integer>> ans, List<Integer> list, int index) {
        if (list.size() == k) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i <= n; i++) {
            list.add(i);
            combine(n, k, ans, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
