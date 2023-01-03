package com.test.leetcode.page1.chapter80.t89;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Solution20230103
 * @Description:
 * @Author: qinfajia
 * @Date: 2023/1/3 08:29
 * @Version: 1.0
 */
public class Solution20230103 {

    @Test
    public void test() {
        System.out.println(JSON.toJSONString(grayCode(2)));
    }

    public List<Integer> grayCode(int n) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (int i = 1; i < (1 << n); i++) {
            list.add(i ^ (i - 1));
        }
        return list;
    }
}
