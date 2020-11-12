package com.test.thread;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-11-12 16:47
 */
public class Solution {

    @Test
    public void test() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<List<Integer>> ans = p(list);
        System.out.println(JSON.toJSONString(ans));
        System.out.println(JSON.toJSONString(list));
    }

    public List<List<Integer>> p(List<Integer> list) {
        List<List<Integer>> ans = new ArrayList<>();
        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        p(ans, array, 0);
        return ans;
    }

    public void p(List<List<Integer>> ans, Integer[] array, int index) {
        if (index == array.length) {
            List<Integer> list = new ArrayList<>();
            for (int i : array) {
                list.add(i);
            }
            ans.add(list);
            return;
        }
        // 需要交换的那个数 array.length-1-index
        for (int i = array.length - 1 - index; i < array.length; i++) {
            turn(array, i, array.length - 1 - index);
            p(ans, array, index + 1);
            turn(array, array.length - 1 - index, i);
        }
    }

    public void turn(Integer[] array, int i1, int i2) {
        int mid = array[i1];
        array[i1] = array[i2];
        array[i2] = mid;
    }

}
