package com.test.leetcode.page2.chapter110.t118;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Solution20230120
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/20 17:53
 * @Version: 1.0
 */
public class Solution20230120 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(generate(5)));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList() {
            {
                add(1);
            }
        });
        for (int i = 2; i <= numRows; i++) {
            List<Integer> l = ans.get(i - 2);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int j = 1; j < l.size(); j++) {
                list.add(l.get(j) + l.get(j - 1));
            }
            list.add(1);
            ans.add(list);
        }
        return ans;
    }
}
