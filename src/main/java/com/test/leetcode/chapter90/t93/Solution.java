package com.test.leetcode.chapter90.t93;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description:
 * @author: qinfajia
 * @create: 2020-12-04 15:59
 */
public class Solution {

    @Test
    public void test() {
        List<String> list = restoreIpAddresses("101023");
        System.out.println(JSON.toJSONString(list));
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        int[] array = new int[4];
        restoreIpAddresses(ans, array, s, 0, 0);
        return ans;
    }

    public void restoreIpAddresses(List<String> ans, int[] array, String s, int index, int count) {
        if (count == 4) {
            if (index == s.length())
                ans.add(new StringBuilder().append(array[0]).append(".").append(array[1]).append(".").append(array[2]).append(".").append(array[3]).toString());
            return;
        }
        if (index >= s.length())
            return;

        if (s.charAt(index) == '0') {
            array[count] = 0;
            restoreIpAddresses(ans, array, s, index + 1, count + 1);
        } else {
            int number = 0;
            for (int i = index; i < s.length() && i < index + 3; i++) {
                number = number * 10 + s.charAt(i) - '0';
                if (number > 255) {
                    // 判断是不是大于255
                    continue;
                }
                array[count] = number;
                restoreIpAddresses(ans, array, s, i + 1, count + 1);
            }
        }
    }
}
