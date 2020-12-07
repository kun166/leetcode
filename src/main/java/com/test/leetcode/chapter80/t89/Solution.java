package com.test.leetcode.chapter80.t89;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-02 16:45
 */
public class Solution {

    @Test
    public void test() {
        List<Integer> list = grayCode(2);
        System.out.println(JSON.toJSONString(list));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>() {{
            add(0);
        }};
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }
        return res;
    }

}
