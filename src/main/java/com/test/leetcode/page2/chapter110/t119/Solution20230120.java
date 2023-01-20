package com.test.leetcode.page2.chapter110.t119;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution20230120
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/20 19:20
 * @Version: 1.0
 */
public class Solution20230120 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(getRow(3)));
        System.out.println(JSON.toJSONString(getRow(4)));
        System.out.println(JSON.toJSONString(getRow(5)));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
        }
        for (int i = 2; i <= rowIndex; i++) {
            int pre = list.get(0);
            for (int j = 1; j < i; j++) {
                int next = list.get(j);
                list.set(j, pre + next);
                pre = next;
            }
        }
        return list;
    }
}
